package com.allen.stone.api.learn.synchronize;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/23 15:47
 **/
public class SynchronizedTest {

    /**
     * @Description: 修饰代码块
     * @param
     * @return
     */
    public void test1(int j){
        synchronized (this){
            for(int i=0; i<10; i++){
                System.out.println("test1 - " + i + " , j" + j);
            }
        }
    }


    /**
     * @Description: 修饰方法, 作用于方法内的对象
     * @param
     * @return
     */
    public synchronized void test2(){
            for(int i=0; i<10; i++){
                System.out.println("test2 - " + i);
            }
    }


    public static void main(String[] args) {
//        作用于调用对象  , 下面结果会交叉执行
        SynchronizedTest test1 = new SynchronizedTest();
        SynchronizedTest test2 = new SynchronizedTest();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(() -> {
            test1.test1(1);
        });
        executor.execute(() -> {
            test2.test1(2);
        });
//        executor.shutdown();
    }

}
