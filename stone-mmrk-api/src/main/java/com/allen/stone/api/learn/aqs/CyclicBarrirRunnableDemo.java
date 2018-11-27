package com.allen.stone.api.learn.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 16:12
 **/
public class CyclicBarrirRunnableDemo {

    public final static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        System.out.println("calback is running");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i<10; i++){
            Thread.sleep(1000);
            final int threadNum = i;
            executorService.execute(()-> {
                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

        }

    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(1000);
        System.out.println(threadNum + " is ready");
        barrier.await();
        System.out.println(threadNum + "is continue");

    }
}
