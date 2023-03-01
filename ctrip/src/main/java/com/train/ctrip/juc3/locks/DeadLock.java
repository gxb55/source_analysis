package com.train.ctrip.juc3.locks;

/**
 * @author xbguo
 * @createTime 2022年06月09日 21:34:00
 */
public class DeadLock {
    private Object objectA = new Object();
    private Object objectB = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread(() -> {
            try {
                deadLock.sayHi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "T1").start();

        new Thread(() -> {
            try {
                deadLock.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();
    }

    public void sayHi() throws InterruptedException {
        synchronized (objectA) {
            System.out.println("sayHi");
            Thread.sleep(1000);
            synchronized (objectB){
                System.out.println("sayHello");
            }
        }
    }

    public void sayHello() throws InterruptedException {
        synchronized (objectB) {
            System.out.println("sayHello");
            Thread.sleep(1000);
            synchronized (objectA){
                System.out.println("sayHi");
            }
        }
    }
}

