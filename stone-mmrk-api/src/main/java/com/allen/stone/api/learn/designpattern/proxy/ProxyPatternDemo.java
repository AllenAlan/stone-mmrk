package com.allen.stone.api.learn.designpattern.proxy;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 21:43
 **/
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");

        // 图像将从磁盘加载
        image.display();
        System.out.println("");
        // 图像不需要从磁盘加载
        image.display();
    }
}