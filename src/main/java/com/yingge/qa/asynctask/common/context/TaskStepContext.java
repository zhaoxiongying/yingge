/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.common.context;

import lombok.Data;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:52
 * @Description: 任务上下文
 */
@Data
public class TaskStepContext {
    /**
     * 租户唯一code
     */
    private String  tenantCode;

    /**
     * 租户名称
     */
    private String  tenantName;
    /**
     * 用户唯一code
     */
    private String  userCode;

    private boolean retry;
}