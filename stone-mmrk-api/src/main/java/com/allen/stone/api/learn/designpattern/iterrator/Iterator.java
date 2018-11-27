package com.allen.stone.api.learn.designpattern.iterrator;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 22:09
 **/
public interface Iterator<T> {
    public boolean hasNext();
    public T next();
}
