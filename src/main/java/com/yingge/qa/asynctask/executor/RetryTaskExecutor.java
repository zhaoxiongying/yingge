/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.executor;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.alipay.bpaas.planet.common.exception.PlanetException;
import com.alipay.bpaas.planetmetadata.asynctask.StepNodeHandler;
import com.alipay.bpaas.planetmetadata.asynctask.common.context.TaskStepContext;
import com.alipay.bpaas.planetmetadata.common.constant.DistLockKey;
import com.alipay.bpaas.planetmetadata.common.lock.DistributedLockTemplate;
import com.alipay.bpaas.planetmetadata.common.retry.RetryTemplate;
import com.alipay.bpaas.planetmetadata.dal.dataobject.AsyncTaskStepDO;
import com.alipay.bpaas.planetmetadata.manager.PlanetAsyncTaskManager;
import com.alipay.bpaas.planetuam.biz.asynctask.AbstractAsyncTaskExecutor;
import com.alipay.remoting.NamedThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:56
 * @Description: 重试任务执行器
 */
@Component
@Slf4j
public class RetryTaskExecutor extends AbstractAsyncTaskExecutor implements CommandLineRunner {

    /**
     * 定时任务线程池
     */
    private final ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
        new NamedThreadFactory("planetmetada-schedule-task-", true));

    @Autowired
    private PlanetAsyncTaskManager asyncTaskManager;

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void run(String... args) throws Exception {
        log.info("schedule task[RetryTask] start！");
        //查询数据库的待重试任务
        executorService.scheduleAtFixedRate(() -> {
            try {
                DistributedLockTemplate.redissonLockExecute(redissonClient,
                    DistLockKey.PLANET_METADATA_SCHEDULE_TASK + "async-task", 60, TimeUnit.SECONDS,
                    () -> {
                        List<AsyncTaskStepDO> asyncTaskStepDOS = asyncTaskManager.listRetryTask();
                        log.info("async-task list:{}", JSON.toJSONString(asyncTaskStepDOS));
                        for (AsyncTaskStepDO asyncTaskStepDO : asyncTaskStepDOS) {
                            if (asyncTaskStepDO.getMaxRetryTimes() > asyncTaskStepDO
                                .getRetryTimes()) {
                                RetryTemplate.guavaRetryExecute(asyncTaskStepDO.getMaxRetryTimes()
                                        - asyncTaskStepDO.getRetryTimes(),
                                    3, TimeUnit.SECONDS, PlanetException.class, () -> {
                                        retryTask(asyncTaskStepDO);
                                        return true;
                                    }, log);
                            }
                        }
                    }, log);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 0, 120, TimeUnit.SECONDS);
    }

    /**
     * 重试主要逻辑
     *
     * @param asyncTaskStepDO
     * @throws ClassNotFoundException
     */
    private void retryTask(AsyncTaskStepDO asyncTaskStepDO) throws ClassNotFoundException,
        PlanetException {
        TaskStepContext taskStepContext = (TaskStepContext)JSONObject.parseObject(
            asyncTaskStepDO.getContextInfo(), Class.forName(asyncTaskStepDO.getContextClass()));
        //重试标志
        taskStepContext.setRetry(true);
        //找到对应步骤开始执行
        StepNodeHandler stepNodeHandler = handlers
            .get(asyncTaskStepDO.getTaskAction() + "-" + asyncTaskStepDO.getStep());
        taskExecute(stepNodeHandler, taskStepContext);
    }
}