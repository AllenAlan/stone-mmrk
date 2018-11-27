package com.allen.stone.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author allen
 * @Description 请求日志处理 aspect
 * @date 2018-9-12 23:10:16
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.allen.stone.*.controller.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("pointcut()")
    public void doAfter() {
        logger.info("=================");
    }

//    @AfterReturning(returning = "object", pointcut = "pointcut()")
//    public void doAfterReturning(Object object) {
//        logger.info("response={}", object.toString());
//    }

//    /**
//     * 抛出异常后的通知
//     * @param joinPoint
//     * @param ex
//     */
//    @AfterThrowing(value = "pointcut()", throwing = "ex")
//    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
//        System.out.println("请求：" + " 出现异常"+ex.getMessage());
//    }

}
