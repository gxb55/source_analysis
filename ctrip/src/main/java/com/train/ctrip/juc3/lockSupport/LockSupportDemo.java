package com.train.ctrip.juc3.lockSupport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo
 * @createTime 2022年06月11日 10:33:00
 */
public class LockSupportDemo {
    public static void main(String[] args) throws InterruptedException {
        //m1_sync();
        //m2_lock();
        /**
         * park unpark 不在意先后顺序，但是只有一次，即多次unpark是没用的
         */
        Thread t1 = new Thread(() -> {
            System.out.println("A 进入");
            LockSupport.park();
            System.out.println("A 出去");

        });
        t1.start();
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            System.out.println("我来唤醒A");
            LockSupport.unpark(t1);
        }).start();
    }

    private static void m2_lock() throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("A 进入");
                condition.await();
                System.out.println("A 出去");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        t1.start();
        Thread.sleep(100);
        new Thread(() -> {
            lock.lock();
            System.out.println("我来唤醒A");
            condition.signal();
            lock.unlock();
        }).start();
    }

    private static void m1_sync() throws InterruptedException {
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                try {
                    System.out.println("A 进入");
                    o.wait();
                    System.out.println("A 出去");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread.sleep(100);
        new Thread(() -> {
            synchronized (o) {
                System.out.println("我来唤醒A");
                o.notifyAll();
            }
        }).start();
    }
}
