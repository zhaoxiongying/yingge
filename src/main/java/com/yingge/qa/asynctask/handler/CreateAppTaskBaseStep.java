/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.handler;

import java.util.List;

import com.alibaba.fastjson.JSON;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planetmetadata.asynctask.StepNodeHandler;
import com.alipay.bpaas.planetmetadata.asynctask.annatation.TaskStep;
import com.alipay.bpaas.planetmetadata.asynctask.common.context.CreateAppContext;
import com.alipay.bpaas.planetmetadata.asynctask.common.context.TaskStepContext;
import com.alipay.bpaas.planetmetadata.asynctask.common.response.TaskResponse;
import com.alipay.bpaas.planetmetadata.common.redis.RedisClient;
import com.alipay.bpaas.planetmetadata.manager.PlanetAsyncTaskManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:57
 * @Description: 创建应用步骤
 */
public class CreateAppTaskBaseStep {

    @Autowired
    protected PlanetAsyncTaskManager asyncTaskManager;

    @Autowired
    protected RedisClient            redisClient;

    /**
     * 保存重试相关信息
     * @param nextStep
     * @param taskStepContext
     */
    public void saveRetryContext(StepNodeHandler nextStep, TaskStepContext taskStepContext) {
        TaskStep taskStep = nextStep.getClass().getAnnotation(TaskStep.class);
        asyncTaskManager.saveTask(taskStep.step(), taskStep.taskAction().getTaskName(),
            taskStep.maxRetryTimes(), nextStep.relationCode(taskStepContext),
            JSON.toJSONString(taskStepContext), taskStepContext.getClass().getCanonicalName(),
            taskStepContext.getUserCode());

    }

    /**
     * 下一步处理
     * @param p
     * @param nextStep
     */
    protected void dealNext(CreateAppContext p, StepNodeHandler nextStep) {
        try {
            TaskResponse<List<String>> taskResponse = nextStep.handle(p);
            if (taskResponse.isSuccess()) {
                nextStep.success(p, taskResponse);
            }
        } catch (PlanetException e) {
            if (!p.isRetry()) {
                //执行失败，保护现场
                saveRetryContext(nextStep, p);
            }
        }
    }
}