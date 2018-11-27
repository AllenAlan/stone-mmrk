package com.allen.stone.api.learn.designpattern.proxy;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 21:41
 **/
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}