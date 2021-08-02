package com.trip.study.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *上锁要解锁才行！！
 * @author Administrator
 */
public class LockReentrantDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"外层");
                lock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"内层");
                }finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        },"A").start();


    }
}
