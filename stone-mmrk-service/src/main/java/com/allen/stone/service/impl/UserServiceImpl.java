package com.allen.stone.service.impl;

import com.allen.stone.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import com.allen.stone.mapper.UserMapper;
import com.allen.stone.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserMapper userMapper;

    @CachePut(value = "user", key = "#user.id")
    @Override
    public User saveOrUpdate(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Cacheable(value = "user", key = "#id")
    @Override
    public User get(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @CacheEvict(value = "user", key = "#id")
    @Override
    public void delete(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
