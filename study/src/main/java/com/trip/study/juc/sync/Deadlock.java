package com.trip.study.juc.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Administrator
 * 死锁演示
 */
public class Deadlock {
    public Lock lock1 = new ReentrantLock();
    public Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        DeadBO deadBO = new DeadBO("1", "2");
        new Thread(() -> {
            try {
                deadlock.test1(deadBO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                deadlock.test2(deadBO);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();

    }

    private void test2(DeadBO deadBO) throws InterruptedException {
        synchronized (deadBO.getAge()) {
            System.out.println(Thread.currentThread().getName() + "test2");
            Thread.sleep(10);
            synchronized (deadBO.getHeight()) {
                System.out.println(Thread.currentThread().getName() + "test2");
            }
        }
    }

    private void test1(DeadBO deadBO) throws InterruptedException {
        synchronized (deadBO.getHeight()) {
            System.out.println(Thread.currentThread().getName() + "test1");
            Thread.sleep(10);
            synchronized (deadBO.getAge()) {
                System.out.println(Thread.currentThread().getName() + "test1");
            }
        }
    }
}

class DeadBO {
    private String age;
    private String height;

    public DeadBO(String age, String height) {
        this.age = age;
        this.height = height;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
