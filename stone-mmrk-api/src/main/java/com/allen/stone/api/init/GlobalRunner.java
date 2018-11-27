package com.allen.stone.api.init;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *@description 初始化读取Config 表中配置, 加载项目配置
 *@Author  allen
 *@Date  2018/10/29
 */
@Component
@Order(2)
@Slf4j
public class GlobalRunner implements CommandLineRunner {

    private Map<String,Object> cache = null;
    @Value("${spring.profiles.active:#{null}}")
    private String active;


    @Override
    public void run(String... args){
        cache = Maps.newHashMap();
        log.info("init global cache...");
        log.info("current project is {} environment", active);
        //TODO
    }
}