package com.train.ctrip.juc3.interrupt;

/**
 * @author xbguo
 * @createTime 2022年06月11日 09:11:00
 */
public class InterruptDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 300; i++) {
                System.out.println("cur: " + i);
            }
            System.out.println("3:" + Thread.currentThread().isInterrupted());
        });
        t1.start();
        System.out.println("1: " + t1.isInterrupted());
        t1.interrupt();
        Thread.sleep(1);
        System.out.println("2: " + t1.isInterrupted());

        Thread.sleep(1000);
        //一秒钟以后线程不活跃了，这个值没有意义了
        System.out.println("4: " + t1.isInterrupted());
    }
}
