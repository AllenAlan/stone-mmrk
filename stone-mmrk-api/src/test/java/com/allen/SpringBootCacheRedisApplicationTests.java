package com.allen;

import com.allen.stone.Application;
import com.allen.stone.domain.User;
import com.allen.stone.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootCacheRedisApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(SpringBootCacheRedisApplicationTests.class);


    @Resource
    private UserService userService;


    @Test
    public void get() {
        final User user = userService.saveOrUpdate(new User(5L, "u5", "p5"));
        log.info("[saveOrUpdate] - [{}]", user);
        final User user1 = userService.get(5L);
        log.info("[get] - [{}]", user1);
//        userService.delete(5L);
    }

}