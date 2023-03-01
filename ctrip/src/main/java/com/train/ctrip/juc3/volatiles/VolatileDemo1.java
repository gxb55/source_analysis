package com.train.ctrip.juc3.volatiles;

/**
 * @author xbguo
 * @createTime 2022年06月11日 16:59:00
 */
public class VolatileDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 10000; j++) {
                    dog.add();
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(dog.count);
    }
}

class Dog {
     int count = 0;

    public synchronized int add() {
        count++;
        return count;
    }
}
