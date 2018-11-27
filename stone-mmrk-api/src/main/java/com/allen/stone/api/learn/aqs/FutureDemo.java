package com.allen.stone.api.learn.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 17:34
 **/
public class FutureDemo {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("do something in callable");
            Thread.sleep(5000);
            return "Done";
        }
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future = executorService.submit(new MyCallable());
        System.out.println("do something in main");
//        Thread.sleep(1000);
        String result = future.get();
        System.out.println("result : " + result);
    }

}
