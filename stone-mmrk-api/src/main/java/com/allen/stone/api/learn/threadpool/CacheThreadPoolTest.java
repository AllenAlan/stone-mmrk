package com.allen.stone.api.learn.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 22:07
 **/
public class CacheThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0 ; i< 10 ; i++){

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("do something ");
                }
            });
            executorService.shutdown();
        }
    }


}
