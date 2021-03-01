/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.handler;

import java.util.List;

import com.alibaba.fastjson.JSON;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planet.common.request.BaseReq;
import com.alipay.bpaas.planetmetadata.asynctask.StepNodeHandler;
import com.alipay.bpaas.planetmetadata.asynctask.annatation.TaskStep;
import com.alipay.bpaas.planetmetadata.asynctask.common.context.CreateAppContext;
import com.alipay.bpaas.planetmetadata.asynctask.common.response.TaskResponse;
import com.alipay.bpaas.planetmetadata.asynctask.enums.TaskActionEnums;
import com.alipay.bpaas.planetmetadata.common.constant.RedisPrefixConstant;
import com.alipay.bpaas.planetmetadata.common.enums.MetaDataErrorEnum;
import com.alipay.bpaas.planetmetadata.core.aliyun.AliyunClientContextFactory;
import com.alipay.bpaas.planetmetadata.facade.enums.AliyunResourcesTypeEnum;
import com.alipay.bpaas.planetmetadata.facade.response.AliyunResourcesDTO;
import com.alipay.bpaas.planetmetadata.facade.response.EnvironmentDTO;
import com.alipay.bpaas.planetmetadata.integration.aliyun.AliyunEdasClient;
import com.alipay.bpaas.planetmetadata.integration.aliyun.context.AliyunClientContext;
import com.alipay.bpaas.planetmetadata.manager.AliyunResourcesManager;
import com.alipay.bpaas.planetmetadata.manager.EnvironmentManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:57
 * @Description: 第一步，创建命名空间，根据当前租户的环境设置初始化对应的空间
 */
@TaskStep(taskAction = TaskActionEnums.CREATE_APP, step = 1)
@Slf4j
public class CreateRegionStep extends CreateAppTaskBaseStep implements
                              StepNodeHandler<CreateAppContext, TaskResponse<List<Long>>> {

    @Autowired
    private AliyunEdasClient           edasClient;

    @Autowired
    private AliyunClientContextFactory aliyunClientContextFactory;

    @Autowired
    private EnvironmentManager         environmentManager;

    /**
     * 下一步处理的
     */
    @Autowired
    private CreateClusterStep          nextStep;

    /**
     * 阿里云资源管理
     */
    @Autowired
    private AliyunResourcesManager     aliyunResourcesManager;

    @Override
    public boolean selfNext() {
        return true;
    }

    @Override
    public boolean breakOff() {
        return true;
    }

    @Override
    public TaskResponse<List<Long>> handle(CreateAppContext taskStepContext) throws PlanetException {
        log.info("Async task[CreateApp] step-one[CreateRegionStep] start execute,context[{}]",
            JSON.toJSONString(taskStepContext));
        AliyunClientContext context;
        try {
            context = aliyunClientContextFactory.get(taskStepContext.getTenantCode());
        } catch (Exception e) {
            log.warn("Build [AliyunContext] exception:{}", e.getMessage());
            throw e;
        }
        //查询租户的环境设置
        BaseReq baseReq = new BaseReq();
        baseReq.setTenantCode(taskStepContext.getTenantCode());
        List<EnvironmentDTO> environmentS = environmentManager.listEnvironment(baseReq);
        List<Long> regionIds = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(environmentS)) {
            try {
                for (EnvironmentDTO environmentDTO : environmentS) {
                    //空间名称:租户名称-项目名称_环境名称 空间id:cn-shanghai:
                    String regionName = taskStepContext.getTenantName() + "-"
                                        + taskStepContext.getAppName() + "_"
                                        + environmentDTO.getName();
                    String regionTag = environmentDTO.getRegionId() + ":"
                                       + taskStepContext.getAppName() + environmentDTO.getType();
                    //设置到redis中保存，说明该命名空间已经创建成功，重试的时候避免再次请求
                    Long count = redisClient.sadd(RedisPrefixConstant.EDAS_CREATED_REGION + ":"
                                                  + taskStepContext.getTenantCode(),
                        regionTag);
                    if (count == 0) {
                        //说明有重复的,那么继续下一个
                        continue;
                    }
                    Long aLong = edasClient.insertOrUpdateRegion(context, null, regionTag,
                        regionName);
                    regionIds.add(aLong);
                    taskStepContext.setEnvironmentDTO(environmentDTO);
                    taskStepContext.setRegionId(regionTag);
                }
            } catch (PlanetException e) {
                //重复创建的不用重试了
                if (MetaDataErrorEnum.EDAS_DUPLICATE_REGION.getCode().equals(e.getErrorCode())) {
                    log.info(
                        "Async task[CreateRegionStep] create fail,but ignore retry!,reason:{},",
                        e.getErrorMsg());
                } else {
                    //其它异常说明创建失败
                    log.info("Tenant[{}] CreateApp[{}] CreateRegionStep Fail!",
                        taskStepContext.getTenantCode(), taskStepContext.getAppCode(), e);
                    //保存已经创建了的
                    if (!CollectionUtils.isEmpty(regionIds)) {
                        saveRegionResources(taskStepContext, regionIds);
                    }
                    throw new PlanetException(MetaDataErrorEnum.EDAS_API_ERROR);
                }
            }
        }
        return TaskResponse.<List<Long>> builder().success(true).data(regionIds).build();
    }

    @Override
    public void success(CreateAppContext taskStepContext, TaskResponse<List<Long>> response) {
        //处理成功
        List<Long> regionIds = response.getData();
        //保存edas命名空间资源数据到aliyun_resource
        saveRegionResources(taskStepContext, regionIds);
        //执行下一步
        dealNext(taskStepContext, nextStep);
    }

    /**
     * 保存阿里云资源
     *
     * @param p
     * @param regionIds
     */
    private void saveRegionResources(CreateAppContext p, List<Long> regionIds) {
        List<AliyunResourcesDTO> resourcesDTOList = Lists.newArrayList();
        for (Long regionId : regionIds) {
            AliyunResourcesDTO resourcesDTO = new AliyunResourcesDTO();
            resourcesDTO.setInstanceType(AliyunResourcesTypeEnum.EDAS_LOGICAL_REGION.getCode());
            resourcesDTO.setInstanceId(String.valueOf(regionId));
            resourcesDTO.setTenantCode(p.getTenantCode());
            resourcesDTOList.add(resourcesDTO);

        }
        log.info("Save AliyunResource edas-cluster info [{}]", JSON.toJSONString(resourcesDTOList));
        aliyunResourcesManager.createAliyunResources(resourcesDTOList, p.getTenantCode(), "");
    }

    @Override
    public StepNodeHandler next() {
        return nextStep;
    }

    @Override
    public String relationCode(CreateAppContext createAppContext) {
        return createAppContext.getAppCode();
    }

}