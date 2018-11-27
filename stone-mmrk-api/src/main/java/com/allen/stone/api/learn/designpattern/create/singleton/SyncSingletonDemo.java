package com.allen.stone.api.learn.designpattern.create.singleton;

import com.allen.stone.common.annotation.NotRecommend;
import com.allen.stone.common.annotation.ThreadSafe;

/**
 * @Author Allen
 * @Description 懒汉模式 单例的实例在调用的时候 创建
 * @Date 2018/10/23 23:22
 **/
@ThreadSafe
@NotRecommend
public class SyncSingletonDemo {

    private SyncSingletonDemo(){}

    private static SyncSingletonDemo instance =null;

    public static synchronized SyncSingletonDemo getInstance(){
        if (instance==null){
            instance = new SyncSingletonDemo();
        }

        return instance;
    }


}
