/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alipay.bpaas.planetuam.biz.asynctask.AbstractAsyncTaskExecutor;
import com.alipay.bpaas.planetuam.biz.asynctask.common.context.TaskStepContext;
import com.alipay.bpaas.planetuam.biz.asynctask.enums.TaskActionEnums;
import com.alipay.remoting.NamedThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:56
 * @Description: 异步任务执行器
 */
@Slf4j
@Component
public class DirectTaskExecutor extends AbstractAsyncTaskExecutor {
    /**
     * 任务执行线程池
     */
    private static final ExecutorService executorService = new ThreadPoolExecutor(1, 1, 0L,
        TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(),
        new NamedThreadFactory("dt-executor", true));

    /**
     * 添加任务执行
     *
     * @param taskAction
     * @param taskStepContext
     */
    public void addTask(TaskActionEnums
        taskAction, TaskStepContext taskStepContext) {
        executorService.submit(() -> {
            log.info("start execute async task[{}]", taskAction.getTaskName());
            //直接执行从第一步开始执行
            taskExecute(handlers.get(taskAction.getTaskName() + "-1"), taskStepContext);
        });
    }
}