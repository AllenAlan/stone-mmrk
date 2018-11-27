package com.allen.stone.api.learn.designpattern.observer;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:56
 **/
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}