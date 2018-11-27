package com.allen.stone.common.hander;

import com.allen.stone.common.exception.BusinessException;
import com.allen.stone.common.result.Result;
import com.allen.stone.common.result.ResultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


/**
 * @Author Allen
 * @Description 异常统一处理
 * @Date 2018/9/12 23:38
 **/
@RestControllerAdvice
public class ExceptionHandlers {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandlers.class);

    /**
     * 400 - Bad Request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        logger.error("参数解析失败", e);
        return ResultUtil.error(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase());
    }


    /**
     * 404
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handleNoHandlerFoundException(NoHandlerFoundException e) {
        logger.error("404 请求地址错误:", e);
        return ResultUtil.error(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase());
    }


    /**
     * 405 - Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error("不支持当前请求方法", e);
        return ResultUtil.error(HttpStatus.METHOD_NOT_ALLOWED.value(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase());
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Result handleHttpMediaTypeNotSupportedException(Exception e) {
        logger.error("不支持当前媒体类型", e);
        return ResultUtil.error(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase());
    }

    /**
     * 500 - Internal Server Error
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleException(RuntimeException e) {
        logger.error("服务运行异常", e);
        e.printStackTrace();
        return ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), "服务运行异常");
    }

    /**
     * BusinessException - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public void businessException(BusinessException e) {
        logger.error(e.getMessage(), e);
//        return ResultUtil.templates.error(e.getCode(), e.getMessage());
    }


}