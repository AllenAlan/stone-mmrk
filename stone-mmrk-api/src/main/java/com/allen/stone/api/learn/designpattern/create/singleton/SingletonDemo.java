package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.NotThreadSafe;

/**
 * @Author Allen
 * @Description 懒汉模式 单例的实例在调用的时候 创建
 * @Date 2018/10/23 23:22
 **/
@NotThreadSafe
public class SingletonDemo {

    private SingletonDemo(){}

    private static SingletonDemo instance =null;

    public static SingletonDemo getInstance(){
        if (instance==null){
            instance = new SingletonDemo();
        }

        return instance;
    }


}
