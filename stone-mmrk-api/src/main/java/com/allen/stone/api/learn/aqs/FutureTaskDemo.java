package com.allen.stone.api.learn.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 17:39
 **/
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });
        new Thread(futureTask).start();
        System.out.println("result : " + futureTask.get());
    }
}
