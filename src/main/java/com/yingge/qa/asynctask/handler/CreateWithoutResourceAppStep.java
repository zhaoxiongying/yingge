/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.handler;

import java.util.ArrayList;
import java.util.List;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planetmetadata.asynctask.StepNodeHandler;
import com.alipay.bpaas.planetmetadata.asynctask.annatation.TaskStep;
import com.alipay.bpaas.planetmetadata.asynctask.common.context.CreateAppContext;
import com.alipay.bpaas.planetmetadata.asynctask.common.response.TaskResponse;
import com.alipay.bpaas.planetmetadata.asynctask.enums.TaskActionEnums;
import com.alipay.bpaas.planetmetadata.common.constant.RedisPrefixConstant;
import com.alipay.bpaas.planetmetadata.common.enums.MetaDataErrorEnum;
import com.alipay.bpaas.planetmetadata.core.aliyun.AliyunClientContextFactory;
import com.alipay.bpaas.planetmetadata.facade.enums.AliyunResourcesTypeEnum;
import com.alipay.bpaas.planetmetadata.facade.enums.AppStatusEnum;
import com.alipay.bpaas.planetmetadata.facade.response.AliyunResourcesDTO;
import com.alipay.bpaas.planetmetadata.integration.aliyun.AliyunEdasClient;
import com.alipay.bpaas.planetmetadata.manager.AliyunResourcesManager;
import com.alipay.bpaas.planetmetadata.manager.PlanetAppManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:57
 * @Description: 第三步，创建无资源应用
 */
@Slf4j(topic = "ASYNC-TASK")
@TaskStep(taskAction = TaskActionEnums.CREATE_APP, step = 3)
public class CreateWithoutResourceAppStep extends CreateAppTaskBaseStep implements
                                          StepNodeHandler<CreateAppContext, TaskResponse<List<String>>> {

    @Autowired
    private AliyunEdasClient           edasClient;

    @Autowired
    private AliyunClientContextFactory aliyunClientContextFactory;

    /**
     * 阿里云资源管理
     */
    @Autowired
    private AliyunResourcesManager     aliyunResourcesManager;

    @Autowired
    private PlanetAppManager           appManager;

    @Override
    public boolean breakOff() {
        return true;
    }

    @Override
    public TaskResponse<List<String>> handle(CreateAppContext createAppContext) throws PlanetException {
        log.info("Async task[CreateApp] step-three[CreateWithoutResourceAppStep] start execute!");
        List<String> appServiceCodeList = createAppContext.getAppServiceCodeList();
        List<String> clusterIds = createAppContext.getClusterIds();
        List<String> appIds = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(appServiceCodeList) && !CollectionUtils.isEmpty(clusterIds)) {
            for (String clusterId : clusterIds) {
                for (String appServiceCode : appServiceCodeList) {
                    try {
                        String appName = createAppContext.getAppName();
                        String edasAppName = appName + "_" + appServiceCode;
                        //同一空间、集群下不能有相同名称的应用
                        Long sadd = redisClient
                            .sadd(RedisPrefixConstant.EDAS_CREATED_APP + ":"
                                  + createAppContext.getRegionId() + ":" + clusterId + edasAppName,
                                appName);
                        if (sadd == 0) {
                            //说明有创建过，来一下个
                            continue;
                        }
                        String appId = edasClient.insertApplication(
                            aliyunClientContextFactory.get(createAppContext.getTenantCode()),
                            edasAppName, clusterId, createAppContext.getRegionId());
                        appIds.add(appId);
                    } catch (Exception e) {
                        //出现异常
                        log.info("Tenant[{}] CreateApp[{}] CreateWithoutResourceAppStep Fail!",
                            createAppContext.getTenantCode(), createAppContext.getAppCode(), e);
                        //保存已经创建成功的
                        if (!CollectionUtils.isEmpty(appIds)) {
                            saveApplicationResources(createAppContext, appIds);
                        }
                        throw new PlanetException(MetaDataErrorEnum.EDAS_API_ERROR);
                    }
                }
            }
        }
        return TaskResponse.<List<String>> builder().data(appIds).success(true).build();
    }

    @Override
    public void success(CreateAppContext createAppContext, TaskResponse<List<String>> s) {
        //保存应用id到aliyun_resource
        List<String> appIds = s.getData();
        saveApplicationResources(createAppContext, appIds);
        //所有的应用创建完毕，最后一步完成，更新行星应用表的状态
        //所有资源创建成功后
        if (!appManager.modifyAppStatus(AppStatusEnum.DEV, createAppContext.getAppCode(),
            createAppContext.getTenantCode())) {
            log.info("async task[CreateRegionStep] modify app status fail!");
        }
    }

    /**
     * 保存应用信息到资源表
     * @param createAppContext
     * @param appIds
     */
    private void saveApplicationResources(CreateAppContext createAppContext, List<String> appIds) {
        List<AliyunResourcesDTO> aliyunResourcesDTOS = new ArrayList<>();
        for (String appId : appIds) {
            AliyunResourcesDTO resourcesDTO = new AliyunResourcesDTO();
            resourcesDTO.setInstanceType(AliyunResourcesTypeEnum.EDAS_APP.getCode());
            resourcesDTO.setInstanceId(appId);
            resourcesDTO.setTenantCode(createAppContext.getTenantCode());
            aliyunResourcesDTOS.add(resourcesDTO);
        }
        aliyunResourcesManager.createAliyunResources(aliyunResourcesDTOS,
            createAppContext.getTenantCode(), "");
    }

    @Override
    public StepNodeHandler next() {
        return null;
    }

    @Override
    public String relationCode(CreateAppContext createAppContext) {
        return createAppContext.getAppCode();
    }
}