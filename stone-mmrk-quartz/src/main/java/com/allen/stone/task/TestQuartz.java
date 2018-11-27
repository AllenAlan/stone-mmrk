package com.allen.stone.task;

import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/16 12:49
 **/
public class TestQuartz extends QuartzJobBean {
    /**
     * 执行定时任务
     * @param jobExecutionContext
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext){
        System.out.println("quartz task "+ LocalDateTime.now());
    }
}