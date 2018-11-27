package com.allen.stone.schedule;

import com.allen.stone.common.exception.BusinessException;
import com.allen.stone.domain.schedule.ScheduleJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ScheduleUtil {

    private final static Logger logger = LoggerFactory.getLogger(ScheduleUtil.class);

    /**
     * 获取 Trigger Key
     *
     * @param scheduleJob
     * @return
     */
    public static TriggerKey getTriggerKey(ScheduleJob scheduleJob) {
        return TriggerKey.triggerKey(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroup());
    }

    /**
     * 获取 Job Key
     *
     * @param scheduleJob
     * @return
     */
    public static JobKey getJobKey(ScheduleJob scheduleJob) {
        return JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
    }

    /**
     * 获取 Cron Trigger
     *
     * @param scheduler
     * @param scheduleJob
     * @return
     * @throws BusinessException
     */
    public static CronTrigger getCronTrigger(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {
        try {
            return (CronTrigger) scheduler.getTrigger(getTriggerKey(scheduleJob));
        } catch (SchedulerException e) {
            throw new BusinessException("Get Cron trigger failed", e);
        }
    }

    /**
     * 创建任务
     *
     * @param scheduler
     * @param scheduleJob
     * @throws BusinessException
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {
        /* 检验cron */
        validateCronExpression(scheduleJob);
        try {
            // 要执行的 Job 的类
            Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(scheduleJob.getClassName()).newInstance().getClass();

            JobDetail jobDetail = JobBuilder.newJob(jobClass)
                    .withIdentity(scheduleJob.getJobName(), scheduleJob.getJobGroup())
                    .withDescription(scheduleJob.getDescription())
                    .build();

            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                    .withIdentity(scheduleJob.getTriggerName(), scheduleJob.getTriggerGroup())
                    .withDescription(scheduleJob.getDescription())
                    .withSchedule(scheduleBuilder)
                    .startNow()
                    .build();

            scheduler.scheduleJob(jobDetail, cronTrigger);

            logger.info("Create schedule job {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());

            if (scheduleJob.isPause()) {
                pauseJob(scheduler, scheduleJob);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BusinessException("Execute schedule job failed", e);
        }
    }


    /**
     * 更新任务
     *
     * @param scheduler
     * @param scheduleJob
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {

        validateCronExpression(scheduleJob);

        try {

            TriggerKey triggerKey = getTriggerKey(scheduleJob);

            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression())
                    .withMisfireHandlingInstructionDoNothing();

            CronTrigger cronTrigger = getCronTrigger(scheduler, scheduleJob);

            cronTrigger = cronTrigger.getTriggerBuilder()
                    .withIdentity(triggerKey)
                    .withDescription(scheduleJob.getDescription())
                    .withSchedule(cronScheduleBuilder).build();

            scheduler.rescheduleJob(triggerKey, cronTrigger);

            logger.info("Update schedule job {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());

            if (scheduleJob.isPause()) {
                pauseJob(scheduler, scheduleJob);
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("Update schedule job failed");
            throw new BusinessException("Update schedule job failed", e);
        }
    }

    /**
     * 执行任务
     *
     * @param scheduler
     * @param scheduleJob
     * @throws BusinessException
     */
    public static void run(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {
        try {
            scheduler.triggerJob(getJobKey(scheduleJob));
            logger.info("Run schedule job {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("Run schedule job failed");
            throw new BusinessException("Run schedule job failed", e);
        }
    }

    /**
     * 暂停任务
     *
     * @param scheduler
     * @param scheduleJob
     */
    public static void pauseJob(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {
        try {
            scheduler.pauseJob(getJobKey(scheduleJob));
            logger.info("Pause schedule job {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("Pause schedule job failed");
            throw new BusinessException("Pause job failed", e);
        }
    }

    /**
     * 继续执行任务
     *
     * @param scheduler
     * @param scheduleJob
     * @throws BusinessException
     */
    public static void resumeJob(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {
        try {
            scheduler.resumeJob(getJobKey(scheduleJob));
            logger.info("Resume schedule job {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("Resume schedule job failed");
            throw new BusinessException("Resume job failed", e);
        }
    }

    /**
     * 删除任务
     *
     * @param scheduler
     * @param scheduleJob
     * @throws BusinessException
     */
    public static void deleteJob(Scheduler scheduler, ScheduleJob scheduleJob) throws BusinessException {
        try {
            scheduler.deleteJob(getJobKey(scheduleJob));
            logger.info("Delete schedule job {}-{} success", scheduleJob.getJobGroup(), scheduleJob.getJobName());
        } catch (SchedulerException e) {
            e.printStackTrace();
            logger.error("Delete schedule job failed");
            throw new BusinessException("Delete job failed", e);
        }
    }

    /**
     * 校验Cron表达式
     */
    public static void validateCronExpression(ScheduleJob scheduleJob) throws BusinessException {
        if (!CronExpression.isValidExpression(scheduleJob.getCronExpression())) {
            throw new BusinessException(String.format("Job %s expression %s is not correct!", scheduleJob.getClassName(), scheduleJob.getCronExpression()));
        }
    }
}