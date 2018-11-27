package com.allen.stone.manage.controller;

import com.allen.stone.common.exception.BusinessException;
import com.allen.stone.common.result.Result;
import com.allen.stone.common.result.ResultUtil;
import com.allen.stone.domain.schedule.ScheduleJob;
import com.allen.stone.service.ScheduleService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/16 0:50
 **/
@RestController
public class MgtScheduleJobController {

    @Resource
    private ScheduleService scheduleService;

    @GetMapping
    public Result getAllJob() {
        return ResultUtil.send(scheduleService.getAllJob());
    }

    @GetMapping("/manage/schedule/{id}")
    public Result getJob(@PathVariable("id") Long id) throws BusinessException {
        return ResultUtil.send(scheduleService.selectByPrimaryKey(id));
    }

    @PutMapping("/manage/schedule/update/{id}")
    public Result updateJob(@PathVariable("id") Long id, @RequestBody ScheduleJob newScheduleJob) throws BusinessException {
        return ResultUtil.send(scheduleService.update(newScheduleJob));
    }

    @DeleteMapping("/manage/schedule/delete/{id}")
    public Result deleteJob(@PathVariable("id") Long id) throws BusinessException {
        return ResultUtil.send(scheduleService.delete(id));
    }

    @PostMapping("/manage/schedule/save")
    public Result saveJob(@RequestBody ScheduleJob newScheduleJob) throws BusinessException {
        return ResultUtil.send(scheduleService.insert(newScheduleJob));
    }


    @GetMapping("/manage/schedule/run/{id}")
    public Result runJob(@PathVariable("id") Long id) throws BusinessException {
        return ResultUtil.send(scheduleService.run(id));
    }


    @GetMapping("/manage/schedule/pause/{id}")
    public Result pauseJob(@PathVariable("id") Long id) throws BusinessException {
        return ResultUtil.send(scheduleService.pause(id));
    }

    @GetMapping("/manage/schedule/resume/{id}")
    public Result resumeJob(@PathVariable("id") Long id) throws BusinessException {
        return ResultUtil.send(scheduleService.resume(id));
    }
}