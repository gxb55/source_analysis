package com.trip.study.base.thread;

/**
 * @author xbguo
 * @createTime 2022年11月27日 11:08:00
 */
public class ProductAndConsumerSync {
    int cur = 0;

    public synchronized void productFood() throws InterruptedException {
        while (cur > 0) {
            this.wait();
        }
        cur = cur + 1;
        System.out.println(Thread.currentThread().getName() + ":" + cur);
        this.notifyAll();
    }

    public synchronized void consumerFood() throws InterruptedException {
        while (cur <= 0) {
            this.wait();
        }
        cur = cur - 1;
        System.out.println(Thread.currentThread().getName() + ":" + cur);
        this.notifyAll();
    }

    public static void main(String[] args) {
        ProductAndConsumerSync productAndConsumerSync = new ProductAndConsumerSync();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    productAndConsumerSync.productFood();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "P" + i).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    productAndConsumerSync.consumerFood();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "C" + i).start();
        }
    }
}
