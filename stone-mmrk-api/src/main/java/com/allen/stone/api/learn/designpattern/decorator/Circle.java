package com.allen.stone.api.learn.designpattern.decorator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 12:01
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}