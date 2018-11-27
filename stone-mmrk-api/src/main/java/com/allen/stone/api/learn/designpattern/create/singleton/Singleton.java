package com.allen.stone.api.learn.designpattern.create.singleton;


/**classloader 登记式枚举
 * @Author Allen
 * @Description
 * @Date 2018/11/1 12:49
 **/
public class Singleton {
    private Singleton (){
        System.out.println("create constructor");
    }
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static final Singleton getInstance() {
        System.out.println("do getInstance...");
        return SingletonHolder.INSTANCE;
    }


    public static void main(String[] args) {
        System.out.println("main begin ...");
        Singleton.getInstance();
        System.out.println("main again ...");
        Singleton.getInstance();
    }
}