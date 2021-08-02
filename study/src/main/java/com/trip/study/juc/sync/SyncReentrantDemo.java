package com.trip.study.juc.sync;

/**
 *sync是可重入锁是非公平锁
 * A线程获取锁后，A线程内的其他操作都不需要再次获取锁了，因为是可重入锁，
 * 要不先打印a线程的所有内容，要不先打印b线程的所有内容
 * @author Administrator
 */
public class SyncReentrantDemo {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"外层");
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }
                }
            }
        },"A").start();

        new Thread(()->{
            synchronized (o){
                System.out.println(Thread.currentThread().getName()+"外层");
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }
                }
            }
        },"B").start();
    }
}
