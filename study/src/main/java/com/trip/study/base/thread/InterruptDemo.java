package com.trip.study.base.thread;

/**
 * @author xbguo
 * @createTime 2022年11月27日 16:55:00
 */
public class InterruptDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A");

        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());

    }
}
