package com.allen.stone.api.learn.designpattern.interpreter;

/**
 * @author Allen
 * @version V1.0.0
 * Copyright All Rights Reserved
 * @date 2018/11/3 21:53
 */
public interface Expression {
    public boolean interpret(String context);
}
