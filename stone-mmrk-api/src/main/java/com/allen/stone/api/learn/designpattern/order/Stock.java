package com.allen.stone.api.learn.designpattern.order;

/**
 * @author Allen
 * @version V1.0.0
 * Copyright All Rights Reserved
 * @date 2018/11/3 18:47
 */
public class Stock {

    public void buy(){
        System.out.println(this.getClass().getName() + "buy");
    }


    public void sell(){
        System.out.println(this.getClass().getName() + "sell");
    }

}
