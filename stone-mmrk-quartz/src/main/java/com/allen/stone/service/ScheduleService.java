package com.allen.stone.service;

import com.allen.stone.common.exception.BusinessException;
import com.allen.stone.domain.schedule.ScheduleJob;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**定时任务Service
 * @author Allen
 * @version V1.0.0
 * Copyright All Rights Reserved
 * @date 2018/10/16 0:12
 */
public interface ScheduleService {
    List<ScheduleJob> selectEnable();

    ScheduleJob selectByPrimaryKey(Long id) throws BusinessException;

    List<ScheduleJob> getAllJob();

    @Transactional(rollbackFor = DataAccessException.class)
    ScheduleJob update(ScheduleJob scheduleJob) throws BusinessException;

    @Transactional(rollbackFor = DataAccessException.class)
    boolean insert(ScheduleJob scheduleJob) throws BusinessException;

    @Transactional(rollbackFor = DataAccessException.class)
    boolean delete(Long id) throws BusinessException;

    /** 继续执行 */
    boolean resume(Long jobId) throws BusinessException;

    /** 暂停*/
    boolean pause(Long jobId) throws BusinessException;

    boolean run(Long jobId) throws BusinessException;

}
