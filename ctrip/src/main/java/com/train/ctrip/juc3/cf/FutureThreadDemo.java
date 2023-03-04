package com.train.ctrip.juc3.cf;

import java.util.concurrent.*;

/**
 * @author xbguo
 * @createTime 2022年06月04日 16:30:00
 */
public class FutureThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //m1();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        long begin = System.currentTimeMillis();
        FutureTask<String> futureTask = new FutureTask<>(()->{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        });
        FutureTask<String> futureTask1 = new FutureTask<>(()->{
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "";
        });
        FutureTask<String> futureTask2 = new FutureTask<>(()->{
            TimeUnit.MILLISECONDS.sleep(100);
            return "";
        });
        executorService.execute(futureTask);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);
        futureTask.get();
        futureTask2.get();
        futureTask1.get();

        long end = System.currentTimeMillis();
        System.out.println(end - begin);

        executorService.shutdown();
    }

    private static void m1() {
        long begin = System.currentTimeMillis();

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }
}
