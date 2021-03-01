/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.annatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.alipay.bpaas.planetuam.biz.asynctask.enums.TaskActionEnums;
import org.springframework.stereotype.Component;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:51
 * @Description: 步骤注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface TaskStep {

    /**
     * 任务名称
     *
     * @return
     */
    TaskActionEnums taskAction();

    /**
     * 最大重试次数
     *
     * @return
     */
    int maxRetryTimes() default 1;

    /**
     * 第几步操作
     *
     * @return
     */
    byte step();

}