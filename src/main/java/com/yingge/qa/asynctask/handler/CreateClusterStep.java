/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.handler;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planetmetadata.asynctask.StepNodeHandler;
import com.alipay.bpaas.planetmetadata.asynctask.annatation.TaskStep;
import com.alipay.bpaas.planetmetadata.asynctask.common.context.CreateAppContext;
import com.alipay.bpaas.planetmetadata.asynctask.common.response.TaskResponse;
import com.alipay.bpaas.planetmetadata.asynctask.enums.TaskActionEnums;
import com.alipay.bpaas.planetmetadata.common.enums.MetaDataErrorEnum;
import com.alipay.bpaas.planetmetadata.core.aliyun.AliyunClientContextFactory;
import com.alipay.bpaas.planetmetadata.facade.enums.AliyunResourcesTypeEnum;
import com.alipay.bpaas.planetmetadata.facade.response.AliyunResourcesDTO;
import com.alipay.bpaas.planetmetadata.facade.response.EnvironmentDTO;
import com.alipay.bpaas.planetmetadata.integration.aliyun.AliyunEdasClient;
import com.alipay.bpaas.planetmetadata.manager.AliyunResourcesManager;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:57
 * @Description: 第二步处理,创建集群信息
 */
@TaskStep(taskAction = TaskActionEnums.CREATE_APP, step = 2)
@Slf4j
public class CreateClusterStep extends CreateAppTaskBaseStep implements
                                            StepNodeHandler<CreateAppContext, TaskResponse<List<String>>> {

    @Autowired
    private CreateWithoutResourceAppStep nextStep;

    @Autowired
    private AliyunResourcesManager       aliyunResourcesManager;

    @Autowired
    private AliyunEdasClient             edasClient;

    @Autowired
    private AliyunClientContextFactory   aliyunClientContextFactory;

    @Override
    public boolean selfNext() {
        return true;
    }

    @Override
    public boolean breakOff() {
        return false;
    }

    @Override
    public TaskResponse<List<String>> handle(CreateAppContext createAppContext) throws PlanetException {
        log.info("Async task[CreateApp] step-two[CreateClusterStep] start execute!context[{}]",
            JSON.toJSONString(createAppContext));
        EnvironmentDTO environmentDTO = createAppContext.getEnvironmentDTO();
        List<String> clusterIds = Lists.newArrayList();
        if (environmentDTO != null && !CollectionUtils.isEmpty(environmentDTO.getVpcList())) {
            List<String> vpcIds = environmentDTO.getVpcList();
            //多个vpc，创建多个cluster
            try {
                for (String vpcId : vpcIds) {
                    //集群的创建允许重复的集群存在
                    String clusterId = edasClient.insertCluster(
                        aliyunClientContextFactory.get(createAppContext.getTenantCode()),
                        environmentDTO.getType() + "_" + vpcId, vpcId,
                        environmentDTO.getRegionId());
                    clusterIds.add(clusterId);
                }
            } catch (Exception e) {
                //出现异常
                log.warn("Tenant[{}] CreateApp[{}] CreateClusterStep Fail! ",
                    createAppContext.getTenantCode(), createAppContext.getAppCode(), e);
                //需要保存已经创建了的
                if (!CollectionUtils.isEmpty(clusterIds)) {
                    saveClusterResources(createAppContext, clusterIds);
                }
                throw new PlanetException(MetaDataErrorEnum.EDAS_API_ERROR);
            }
        }
        return TaskResponse.<List<String>> builder().data(clusterIds).success(true).build();
    }

    @Override
    public void success(CreateAppContext p, TaskResponse<List<String>> response) {
        //处理成功,保存edas集群资源数据到aliyun_resource
        List<String> clusterList = response.getData();
        saveClusterResources(p, clusterList);
        p.setClusterIds(clusterList);
        //执行下一步
        dealNext(p, nextStep);
    }

    /**
     * 保存edas集群资源信息
     * @param p
     * @param clusterList
     */
    private void saveClusterResources(CreateAppContext p, List<String> clusterList) {
        List<AliyunResourcesDTO> aliyunResourcesDTOS = new ArrayList<>();
        for (String clusterId : clusterList) {
            AliyunResourcesDTO resourcesDTO = new AliyunResourcesDTO();
            resourcesDTO.setInstanceType(AliyunResourcesTypeEnum.EDAS_CLUSTER.getCode());
            resourcesDTO.setInstanceId(clusterId);
            resourcesDTO.setTenantCode(p.getTenantCode());
            aliyunResourcesDTOS.add(resourcesDTO);
        }
        aliyunResourcesManager.createAliyunResources(aliyunResourcesDTOS, p.getTenantCode(), "");
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