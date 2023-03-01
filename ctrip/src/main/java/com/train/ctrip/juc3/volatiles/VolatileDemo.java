package com.train.ctrip.juc3.volatiles;

/**
 * @author xbguo
 * @createTime 2022年06月11日 16:36:00
 * volatile 保证可见性
 * 禁止指令重排
 * 不保证原子性
 */
public class VolatileDemo {
    volatile static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            System.out.println("come in " + Thread.currentThread().getName());
            while (flag) {

            }
            System.out.println("break");
        }, "T1").start();

        Thread.sleep(1000);
        flag = false;
        System.out.println(Thread.currentThread().getName() + " " + flag);
    }
}
