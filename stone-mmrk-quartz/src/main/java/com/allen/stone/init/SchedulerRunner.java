package com.allen.stone.init;

import com.allen.stone.common.exception.BusinessException;
import com.allen.stone.schedule.ScheduleUtil;
import com.allen.stone.domain.schedule.ScheduleJob;
import com.allen.stone.service.ScheduleService;
import org.quartz.CronTrigger;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SchedulerRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private ScheduleService scheduleService;

    @Resource
    private Scheduler scheduler;

    @Override
    public void run(String... args){

        // 应用启动之后执行所有可执行的的任务
        List<ScheduleJob> scheduleJobList = scheduleService.selectEnable();
        for (ScheduleJob scheduleJob : scheduleJobList) {
            try {
                CronTrigger cronTrigger = ScheduleUtil.getCronTrigger(scheduler, scheduleJob);
                if (cronTrigger == null) {
                    ScheduleUtil.createScheduleJob(scheduler, scheduleJob);
                } else {
                    ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);
                }
                logger.info("Startup {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }
    }
}