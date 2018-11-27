package com.allen.stone.service.impl;

import com.allen.stone.common.exception.BusinessException;
import com.allen.stone.domain.schedule.ScheduleJob;
import com.allen.stone.mapper.schedule.ScheduleJobMapper;
import com.allen.stone.service.ScheduleService;
import org.quartz.Scheduler;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.allen.stone.schedule.ScheduleUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * 定时任务service
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/15 23:59
 **/

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Resource
    private ScheduleJobMapper scheduleJobMapper;

    @Resource
    private Scheduler scheduler;


    @Override
    public List<ScheduleJob> selectEnable() {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setEnable(true);
        return scheduleJobMapper.select(scheduleJob);
    }

    @Override
    public ScheduleJob selectByPrimaryKey(Long id) throws BusinessException {
        ScheduleJob scheduleJob = scheduleJobMapper.selectByPrimaryKey(id);
        if (scheduleJob == null) {
            throw new BusinessException("ScheduleJob:" + id + " not found");
        }
        return scheduleJob;
    }

    @Override
    public List<ScheduleJob> getAllJob() {
        return scheduleJobMapper.selectAll();
    }

    @Transactional(rollbackFor = DataAccessException.class)
    @Override
    public ScheduleJob update(ScheduleJob scheduleJob) throws BusinessException {

        if (scheduleJobMapper.updateByPrimaryKeySelective(scheduleJob) <= 0) {
            throw new BusinessException("Update product:" + scheduleJob.getId() + "failed");
        }
        ScheduleUtil.updateScheduleJob(scheduler, scheduleJob);

        return scheduleJob;
    }

    @Override
    @Transactional(rollbackFor = DataAccessException.class)
    public boolean insert(ScheduleJob scheduleJob) throws BusinessException {
        Integer num = scheduleJobMapper.insert(scheduleJob);
        if (num <= 0) {
            throw new BusinessException("Add product failed");
        }

        ScheduleUtil.createScheduleJob(scheduler, scheduleJob);

        return true;
    }

    @Override
    @Transactional(rollbackFor = DataAccessException.class)
    public boolean delete(Long id) throws BusinessException {
        ScheduleJob scheduleJob = scheduleJobMapper.selectByPrimaryKey(id);

        Integer num = scheduleJobMapper.deleteByPrimaryKey(id);
        if (num <= 0) {
            throw new BusinessException("Delete product:" + id + "failed");
        }
        ScheduleUtil.deleteJob(scheduler, scheduleJob);
        return true;
    }

    @Override
    public boolean resume(Long jobId) throws BusinessException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, false);
        ScheduleUtil.resumeJob(scheduler, scheduleJob);
        return true;
    }

    @Override
    public boolean pause(Long jobId) throws BusinessException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, true);
        ScheduleUtil.pauseJob(scheduler, scheduleJob);
        return true;
    }

    @Override
    public boolean run(Long jobId) throws BusinessException {
        ScheduleJob scheduleJob = updateScheduleJobStatus(jobId, false);
        ScheduleUtil.run(scheduler, scheduleJob);
        return true;
    }

    public ScheduleJob updateScheduleJobStatus(Long jobId, Boolean isPause) throws BusinessException {
        ScheduleJob scheduleJob = selectByPrimaryKey(jobId);
//        scheduleJob.setPause(isPause);
        update(scheduleJob);
        return scheduleJob;
    }


}
