package com.allen.stone.api.learn.designpattern.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Allen
 * @Description
 * @Date 2018/11/3 18:50
 **/
public class Broker {

    private List<Order> orderList = new ArrayList<Order>();


    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.executor();
        }
        orderList.clear();
    }





    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock();
        SellStock sellStockOrder = new SellStock();

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }







}
