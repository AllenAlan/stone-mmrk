package com.allen.stone.common.result;/**
 * @Author Allen
 * @Description
 * @Date 2018/9/12 18:59
 **/

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @Author Allen
 * @Description 响应实体
 * @Date 2018/9/12 18:59
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    /** 响应码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
