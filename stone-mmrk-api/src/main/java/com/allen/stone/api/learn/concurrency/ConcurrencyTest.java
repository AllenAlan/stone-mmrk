package com.allen.stone.api.learn.concurrency;

import com.allen.stone.common.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**Semaphore 阻塞线程,可以限制同一时间并发量
 * @Author Allen
 * @Description
 * @Date 2018/10/22 17:21
 **/

@Slf4j
@NotThreadSafe
public class ConcurrencyTest {


    public static int clientTotal = 5000;

    public static int threadTotal = 200;

    public static int count = 0;

    private final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i<clientTotal;i++){
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    log.error("exception : ", e);
                }
                countDownLatch.countDown();
            });

        }

        countDownLatch.await();
//        log.info("count:  " + count);
        System.out.println("count: " + count);
        executorService.shutdown();
    }

    private static void add() {
        count++;
    }


}
