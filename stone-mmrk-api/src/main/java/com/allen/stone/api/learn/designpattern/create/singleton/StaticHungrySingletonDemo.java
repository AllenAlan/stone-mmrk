package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.ThreadSafe;

/**
 * @Author Allen
 * @Description 饿汉模式
 * @Date 2018/10/23 23:29
 **/
@ThreadSafe
public class StaticHungrySingletonDemo {

    private StaticHungrySingletonDemo(){}

    private static StaticHungrySingletonDemo instance;

    static {
        instance = new StaticHungrySingletonDemo();
    }

    public static StaticHungrySingletonDemo getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());

        System.out.println(getInstance().hashCode());
    }
}
