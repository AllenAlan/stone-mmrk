package com.allen.stone.api.learn.threadpool;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author Allen
 * @Description
 * @Date 2018/10/26 22:07
 **/
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
        for(int i = 0 ; i< 10 ; i++){
//            executorService.schedule(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("do something ");
//                }
//            }, 3, TimeUnit.SECONDS);
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    System.out.println("schedule run");
                }
            }, 1, 3, TimeUnit.SECONDS);
//            executorService.shutdown();


            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("timer run");
                }
            },  new Date(), 5*1000);
        }
    }


}
