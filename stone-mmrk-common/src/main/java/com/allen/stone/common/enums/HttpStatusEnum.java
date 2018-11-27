package com.allen.stone.common.enums;

/**
 * 响应码
 *
 * @author Allen
 * @version V1.0.0
 * @date 2018/9/12 23:36
 */
public enum HttpStatusEnum {
    ;
    private final int value;
    private final String reasonPhrase;

    HttpStatusEnum(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int getValue() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
