package com.allen.stone.api.learn.concurrency;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/23 13:47
 **/
public class AtomicReferenceTest {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    public static void main(String[] args) {
        count.compareAndSet(0,2);
        count.compareAndSet(1,6);
        count.compareAndSet(2,3);
        count.compareAndSet(3,4);
        count.compareAndSet(4,5);
        System.out.println("count: " + count);
    }




}
