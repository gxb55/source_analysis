package com.train.ctrip.juc3.base;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年06月04日 16:03:00
 */
public class ThreadDemo {


    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        }, "t1");
        thread.start();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 100L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        threadPoolExecutor.execute(() -> {
            System.out.println(66);
        });


        threadPoolExecutor.shutdown();
    }
}
