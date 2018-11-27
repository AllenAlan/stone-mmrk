package com.allen.stone.common.exception;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Allen
 * @Description 系统业务异常
 * @Date 2018/9/12 23:48
 **/
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 5037766787969001357L;
    private final static Logger logger = LoggerFactory.getLogger(BusinessException.class);
    /**
     * 异常码
     */
    private Integer code;

    /**
     * 异常描述
     */
    private String message;

    public BusinessException(String message){
        super();
        this.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        this.setMessage(message);
    }

    public BusinessException(Integer code, String message){
        super();
        this.setCode(code);
        this.setMessage(message);
    }

    public BusinessException(String message, Throwable cause,
                             boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }



    public BusinessException(Throwable cause) {
        super(cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
