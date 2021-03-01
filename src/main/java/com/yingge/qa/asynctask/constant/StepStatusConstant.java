/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.constant;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:55
 * @Description: 执行状态
 */
public class StepStatusConstant {
    /**
     * 待执行
     */
    public static final byte WAITING_EXECUTE    = 1;
    /**
     * 执行成功
     */
    public static final byte EXECUTE_SUCCESSFUL = 2;

    /**
     * 执行失败，重试最大次数后仍然不成功的状态
     */
    public static final byte EXECUTE_FAILED     = 3;
}