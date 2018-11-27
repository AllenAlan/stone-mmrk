package com.allen.stone.api.learn.designpattern.order;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 18:48
 **/
public class SellStock extends Stock implements Order {
    @Override
    public void executor() {
        sell();
    }
}
