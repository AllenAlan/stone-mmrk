package com.allen.stone.service;

import com.allen.stone.domain.User;
public interface UserService{

    User saveOrUpdate(User user);

    User get(Long id);

    void delete(Long id);

    int insert(User user);


}
