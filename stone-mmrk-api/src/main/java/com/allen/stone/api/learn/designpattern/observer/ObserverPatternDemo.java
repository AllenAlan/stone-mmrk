package com.allen.stone.api.learn.designpattern.observer;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 23:06
 **/
public class ObserverPatternDemo {


    public static void main(String[] args) {
        Subject subject = new Subject();
        new BObserver(subject);
        new AObserver(subject);
        new CObserver(subject);

        subject.setState("15");
        subject.setState("10");


    }


}
