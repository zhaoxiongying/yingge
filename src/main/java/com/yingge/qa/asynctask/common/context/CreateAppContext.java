/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.common.context;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:52
 * @Description: 创建应用的异步任务执行参数
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CreateAppContext extends TaskStepContext {
    /**
     * app唯一code
     */
    private String appCode;
    /**
     * 应用名称
     */
    private String appName;

    /**
     * 空间id
     */
    private String regionId;

    /**
     * 环境
     */
    //private EnvironmentDTO environmentDTO;

    /**
     * 应用服务code
     */
    private List<String> appServiceCodeList;

    /**
     * 集群ids
     */
    private List<String> clusterIds;

}