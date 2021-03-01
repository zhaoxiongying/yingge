/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planetuam.biz.asynctask.common.context.TaskStepContext;
import com.alipay.bpaas.planetuam.biz.asynctask.common.response.TaskResponse;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:58
 * @Description: 异步任务执行handler
 */
public interface StepNodeHandler<P extends TaskStepContext, R extends TaskResponse> {
    /**
     * 是否每个步骤自动执行下一步，
     *否的话托管给执行器进行
     * @return
     */
    default boolean selfNext() {
        return false;
    }

    /**
     * 执行失败后是否中断后续步骤执行
     * @return
     */
    boolean breakOff();

    /**
     * 步骤处理主要逻辑
     * @param p
     * @return
     */
    R handle(P p) throws PlanetException;

    /**
     * 失败处理
     * @param p
     */
    default void fail(P p) {

    }

    /**
     * 成功处理
     * @param p
     * @param r
     */
    default void success(P p, R r) {

    }

    /**
     * 获取下一步骤
     * @return
     */
    StepNodeHandler next();

    /**
     * 关联主题code
     * @param p
     * @return
     */
    String relationCode(P p);

}