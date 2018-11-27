package com.allen.stone.mapper;

import com.allen.stone.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据用户名统计
     *
     * @param username 用户名
     * @return 统计结果
     */
    int countByUsername(String username);

}
