package com.allen.stone.api.learn.designpattern.create.factory;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/2 19:24
 **/
public interface Car {

//    void driver();

    default void driver(){
        System.out.println(getClass().getName()+" driver");
    }

}
