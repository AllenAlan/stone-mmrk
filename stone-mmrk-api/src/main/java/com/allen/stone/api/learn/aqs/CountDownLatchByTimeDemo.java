package com.allen.stone.api.learn.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 11:15
 **/
public class CountDownLatchByTimeDemo {

    private final static int threadCount = 5000;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch countDownLatch = new CountDownLatch((threadCount));

        for (int i = 0;
             i < threadCount;
             i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    test(threadNum);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
            
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        executorService.shutdown();
        System.out.println("finish work");
    }

    private static void test(int threadNum) throws InterruptedException {
//        Thread.sleep(100);
        System.out.println("threadNum : " + threadNum);
    }

}
