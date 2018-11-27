package com.allen.stone.common.result;

import org.springframework.http.HttpStatus;

/**
 * @Author Allen
 * @Description
 * @Date 2018/9/12 18:59
 **/
public class ResultUtil {

    public static Result send(Object object) {
        Result result = new Result();
        result.setCode(HttpStatus.OK.value());
        result.setMsg(HttpStatus.OK.getReasonPhrase());
        if (object != null) {
            result.setData(object);
        }
        return result;
    }

    public static Result sendBoolean(int isSuccess) {
        Result result = new Result();
        if (isSuccess == 1) {
            result.setCode(HttpStatus.OK.value());
            result.setMsg(HttpStatus.OK.getReasonPhrase());
        } else {
            result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            result.setMsg(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        }
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
