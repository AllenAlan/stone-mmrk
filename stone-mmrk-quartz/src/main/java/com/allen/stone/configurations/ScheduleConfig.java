package com.allen.stone.configurations;


import com.allen.stone.schedule.ScheduleJobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/15 23:39
 **/
@Configuration
public class ScheduleConfig {

    @Resource
    private ScheduleJobFactory scheduleJobFactory;

    @Bean
    @Qualifier("scheduleBean")
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("dataSource") DataSource dataSource) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setSchedulerName("TASK_EXECUTOR");
        /* 延迟10秒启动*/
        schedulerFactoryBean.setStartupDelay(16);
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setDataSource(dataSource);
        // 将 JobFactory 改为自定义的，否则在 Job 中注入 Bean 会失败
        schedulerFactoryBean.setJobFactory(scheduleJobFactory);
        return schedulerFactoryBean;
    }
}