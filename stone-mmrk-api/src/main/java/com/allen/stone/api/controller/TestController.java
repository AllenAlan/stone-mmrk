package com.allen.stone.api.controller;

import com.allen.stone.api.learn.immutable.ThreadLocalHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/22 15:45
 **/
@Slf4j
@RestController
public class TestController {


    @GetMapping("test/currency")
    public String test(){
        log.info("有显示 log");
        return "test";
    }

    @GetMapping("test/threadLocal")
    public String testThreadLocal(){
        log.info("TestController {} {}", "hahaahaha",ThreadLocalHolder.getId());
        return "test";
    }

}
