package com.allen.stone.api.learn.concurrency;

import com.allen.stone.common.annotation.ThreadSafe;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/23 13:52
 **/
@ThreadSafe
public class AtomicFieldUpdaterTest {

    private static AtomicIntegerFieldUpdater<AtomicFieldUpdaterTest> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicFieldUpdaterTest.class,"count");

    @Getter
    /*  必须有volatile 修饰, 且必须非 static*/
    public volatile int count = 100;




    public static void main(String[] args) {
        AtomicFieldUpdaterTest atomictest = new AtomicFieldUpdaterTest();
        if(updater.compareAndSet(atomictest, 100, 120)){
            System.out.println("udpate success 1 count =  " + atomictest.getCount());
        }

        if(updater.compareAndSet(atomictest, 100, 120)){
            System.out.println("udpate success 2 count =  " + atomictest.getCount());
        } else {
            System.out.println("udpate failed 2 count =  " + atomictest.getCount());
        }
    }


}
