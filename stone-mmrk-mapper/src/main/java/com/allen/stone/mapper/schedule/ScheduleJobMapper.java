package com.allen.stone.mapper.schedule;

import com.allen.stone.domain.schedule.ScheduleJob;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**定时任务Mapper
 * @Author Allen
 * @Description
 * @Date 2018/10/16 0:05
 **/
@Mapper
public interface ScheduleJobMapper extends BaseMapper<ScheduleJob> {


}