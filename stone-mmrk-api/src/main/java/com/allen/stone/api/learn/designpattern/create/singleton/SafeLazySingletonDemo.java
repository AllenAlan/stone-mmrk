package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.NotRecommend;
import com.allen.stone.common.annotation.ThreadSafe;

/**
 * @Author Allen
 * @Description 懒汉模式 双重校验
 * @Date 2018/10/23 23:22
 **/
@ThreadSafe
@NotRecommend
public class SafeLazySingletonDemo {

    private SafeLazySingletonDemo(){}

    private volatile static SafeLazySingletonDemo instance =null;

    // 1. memory = allocate() 分配对象内存空间
    // 2. ctorInstance()  初始化对象
    // 3. isntance = memory 设置instance 指向分配的内存

    //单例模式 volatile 和双重检测模式 防止指令重拍
    public static SafeLazySingletonDemo getInstance(){
        if (instance==null){
            synchronized(SafeLazySingletonDemo.class){
                if (instance==null){
                    instance = new SafeLazySingletonDemo();
                }
            }
        }

        return instance;
    }


}
