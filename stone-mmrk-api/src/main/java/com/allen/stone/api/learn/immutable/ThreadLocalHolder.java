package com.allen.stone.api.learn.immutable;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/25 20:58
 **/
public class ThreadLocalHolder {

    private final static ThreadLocal<Long> reqholder = new ThreadLocal<>();
    public static void add(Long id){
        reqholder.set(id);
    }

    public static Long getId(){
        return reqholder.get();
    }

    public static void remove(){
        reqholder.remove();
    }
}
