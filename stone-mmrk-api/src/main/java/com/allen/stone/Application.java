package com.allen.stone;

import com.allen.stone.api.interceptors.TestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

@SpringBootApplication
@ServletComponentScan(value = "com.allen.stone")
@EnableCaching
@EnableConfigurationProperties
@Slf4j
public class Application extends WebMvcConfigurationSupport {

    @Resource
    private TestInterceptor testInterceptor;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor).addPathPatterns("/test/*");
        super.addInterceptors(registry);
    }
}
