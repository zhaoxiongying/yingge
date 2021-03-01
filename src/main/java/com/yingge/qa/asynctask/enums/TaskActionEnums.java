/**
 * iWhaleCloud.com | Create value for customers
 */
package com.yingge.qa.asynctask.enums;

/**
 * @Author: 鹰哥 zhaoxiongy@163.com
 * @Date: 2021/3/1 17:56
 * @Description: 异步任务动作类型
 */
public enum TaskActionEnums {
                             /**
                              * 创建应用操作
                              */
                             CREATE_APP("CreateApp", "创建应用");

    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 任务描述
     */
    private String desc;

    TaskActionEnums(String taskName, String desc) {
        this.taskName = taskName;
        this.desc = desc;
    }

    public static TaskActionEnums getTaskAction(String taskName) {
        for (TaskActionEnums value : values()) {
            if (value.getTaskName().equals(taskName)) {
                return value;
            }
        }
        return null;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDesc() {
        return desc;
    }
}