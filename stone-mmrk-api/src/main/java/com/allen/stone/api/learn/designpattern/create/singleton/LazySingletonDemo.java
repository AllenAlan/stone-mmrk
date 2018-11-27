package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.NotRecommend;
import com.allen.stone.common.annotation.NotThreadSafe;

/**
 * @Author Allen
 * @Description 懒汉模式 双重校验
 * @Date 2018/10/23 23:22
 **/
@NotThreadSafe
@NotRecommend
public class LazySingletonDemo {

    private LazySingletonDemo(){}

    private static LazySingletonDemo instance =null;



    // 1. memory = allocate() 分配对象内存空间
    // 2. ctorInstance()  初始化对象
    // 3. isntance = memory 设置instance 指向分配的内存

    //  多线程下 会发生指令重排序  JVM 和cpu 优化

    // 1. memory = allocate() 分配对象内存空间
    // 2. ctorInstance()  初始化对象
    // 3. isntance = memory 设置instance 指向分配的内存

    public static LazySingletonDemo getInstance(){
        if (instance==null){
            synchronized(LazySingletonDemo.class){
                if (instance==null){
                    instance = new LazySingletonDemo();
                }
            }
        }

        return instance;
    }


}
