package com.allen.stone.api.learn.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 16:12
 **/
public class CyclicBarrirBrokenDemo {

    public final static CyclicBarrier barrier = new CyclicBarrier(5);

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
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            });

        }
        executorService.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException, TimeoutException {
        Thread.sleep(1000);
        System.out.println(threadNum + " is ready");
        try {

            barrier.await(2, TimeUnit.SECONDS);
        }catch (BrokenBarrierException | TimeoutException e){
            System.out.println(e);
        }
        System.out.println(threadNum + " is continue");

    }
}
