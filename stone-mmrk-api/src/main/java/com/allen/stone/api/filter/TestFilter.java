package com.allen.stone.api.filter;

import com.allen.stone.api.learn.immutable.ThreadLocalHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/25 21:25
 **/
@Slf4j
@WebFilter(urlPatterns = "/test/*")
public class TestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){
        log.info("TestFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("TestFilter doFilter {}", Thread.currentThread().getId());
        ThreadLocalHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
