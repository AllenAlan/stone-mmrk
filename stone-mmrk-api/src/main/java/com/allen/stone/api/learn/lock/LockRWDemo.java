package com.allen.stone.api.learn.lock;

import com.allen.stone.common.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Semaphore 阻塞线程,可以限制同一时间并发量
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/22 17:21
 **/

@Slf4j
@NotThreadSafe
public class LockRWDemo {

    private final Map<String, Data> map = new TreeMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock wirteLock = lock.writeLock();


}
