package com.allen.stone.api.learn.designpattern.decorator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 12:01
 **/
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}