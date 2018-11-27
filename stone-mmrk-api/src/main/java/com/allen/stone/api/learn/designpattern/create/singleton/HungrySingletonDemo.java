package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.ThreadSafe;

/**
 * @Author Allen
 * @Description 饿汉模式
 * @Date 2018/10/23 23:29
 **/
@ThreadSafe
public class HungrySingletonDemo {

    private HungrySingletonDemo(){}

    private static HungrySingletonDemo instance = new HungrySingletonDemo();

    public static HungrySingletonDemo getInstance(){
        return instance;
    }
}
