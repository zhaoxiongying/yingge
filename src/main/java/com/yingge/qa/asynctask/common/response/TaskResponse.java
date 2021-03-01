/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.common.response;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:55
 * @Description: 任务返回值收集
 */
@Data
@Builder
public class TaskResponse<T> {

    private boolean success;
    private String  message;
    T               data;

}