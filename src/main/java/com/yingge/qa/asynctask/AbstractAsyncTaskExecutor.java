/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSON;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planetuam.biz.asynctask.annatation.TaskStep;
import com.alipay.bpaas.planetuam.biz.asynctask.common.context.TaskStepContext;
import com.alipay.bpaas.planetuam.biz.asynctask.common.response.TaskResponse;
import com.alipay.bpaas.planetuam.biz.asynctask.enums.TaskActionEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:58
 * @Description: 异步任务执行器
 */
@Slf4j
public abstract class AbstractAsyncTaskExecutor implements InitializingBean {

    @Autowired
    protected List<StepNodeHandler>                  stepNodeHandlerList;

    @Autowired
    protected PlanetAsyncTaskManager                 asyncTaskManager;

    /**
     * 处理器
     */
    protected final HashMap<String, StepNodeHandler> handlers = new HashMap<>();

    /**
     * 执行异步任务
     *
     * @param stepNodeHandler
     * @param taskStepContext
     */
    protected void taskExecute(StepNodeHandler stepNodeHandler,
                               TaskStepContext taskStepContext) throws PlanetException {
        if (stepNodeHandler == null) {
            return;
        }
        TaskResponse handleResult;
        try {
            handleResult = stepNodeHandler.handle(taskStepContext);
        } catch (PlanetException e) {
            log.warn("Async task execute biz-exception!", e);
            //异常捕获，返回结果为失败
            handleResult = TaskResponse.builder().success(false).build();
        } catch (Exception e) {
            log.warn("Async task execute other-exception!", e);
            //未知异常
            handleResult = TaskResponse.builder().success(false).build();
        }
        log.info("Async task[] execute result:{}", JSON.toJSONString(handleResult));
        //继续执行下一步
        if (handleResult.isSuccess()) {
            //执行成功后的操作
            stepNodeHandler.success(taskStepContext, handleResult);
        } else {
            TaskStep taskStep = stepNodeHandler.getClass().getAnnotation(TaskStep.class);
            log.warn("[{}] async task execute fail! context[{}]",
                taskStep.taskAction().getTaskName(), JSON.toJSONString(taskStepContext));
            //执行失败
            stepNodeHandler.fail(taskStepContext);
            if (!taskStepContext.isRetry()) {
                //不是重试就保存当前任务到数据库
                saveRetryContext(stepNodeHandler, taskStepContext, taskStep);
            }
            if (stepNodeHandler.breakOff()) {
                //中断情况下,抛出异常,不再执行
                //throw new PlanetException(MetaDataErrorEnum.ASYNC_TASK_EXECUTE_FAIL);
            }
        }
        if (!stepNodeHandler.selfNext()) {
            //继续执行下一步
            taskExecute(stepNodeHandler.next(), taskStepContext);
        }
    }

    /**
     * 保护现场，进行重试
     *
     * @param stepNodeHandler
     * @param taskStepContext
     * @param taskStep
     */
    private void saveRetryContext(StepNodeHandler stepNodeHandler, TaskStepContext taskStepContext,
                                  TaskStep taskStep) {
        log.info("handler[{}] save retry context[{}]", taskStep.taskAction().getTaskName(),
            JSON.toJSONString(taskStepContext));
        asyncTaskManager.saveTask(taskStep.step(), taskStep.taskAction().getTaskName(),
            taskStep.maxRetryTimes(), stepNodeHandler.relationCode(taskStepContext),
            JSON.toJSONString(taskStepContext), taskStepContext.getClass().getCanonicalName(),
            taskStepContext.getUserCode());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (StepNodeHandler stepNodeHandler : stepNodeHandlerList) {
            TaskStep taskStep = stepNodeHandler.getClass().getAnnotation(TaskStep.class);
            TaskActionEnums key = taskStep.taskAction();
            handlers.put(key.getTaskName() + "-" + taskStep.step(), stepNodeHandler);
        }
    }
}