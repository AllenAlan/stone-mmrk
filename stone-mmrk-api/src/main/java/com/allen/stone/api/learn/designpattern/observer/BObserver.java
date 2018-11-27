package com.allen.stone.api.learn.designpattern.observer;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 23:04
 **/
public class BObserver extends Observer {

    public BObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "B String: " +  subject.getState());
    }
}
