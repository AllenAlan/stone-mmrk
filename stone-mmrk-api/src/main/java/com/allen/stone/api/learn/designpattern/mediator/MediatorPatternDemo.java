package com.allen.stone.api.learn.designpattern.mediator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:31
 **/
public class MediatorPatternDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}