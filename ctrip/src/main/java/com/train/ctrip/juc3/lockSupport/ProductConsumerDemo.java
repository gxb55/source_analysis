package com.train.ctrip.juc3.lockSupport;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo
 * @createTime 2022年06月11日 09:45:00
 */
public class ProductConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        //foodProductSynchronized();
        FoodProductLock product = new FoodProductLock();
        new Thread(() -> {
            try {
                product.create();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C" + 1).start();
        Thread.sleep(10);

        new Thread(() -> {
            try {
                product.eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "E" + 1).start();
    }

    private static void foodProductSynchronized() throws InterruptedException {
        FoodProductSynchronized product = new FoodProductSynchronized();

        new Thread(() -> {
            try {
                product.create();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "C" + 1).start();
        Thread.sleep(20);

        new Thread(() -> {
            try {
                product.eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "E" + 1).start();
    }
}

class FoodProductLock {
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    volatile int i = 0;

    public void create() throws InterruptedException {
        while (true) {
            lock.lock();
            if (i == 0) {
                i++;
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " 生产一个，" + i);
                condition2.signal();
                condition1.await();
            } else {
                condition1.await();
            }
            lock.unlock();
        }

    }

    public  void eat() throws InterruptedException {
        while (true) {
            lock.lock();
            if (i == 0) {
                condition2.await();
            } else {
                i--;
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " 消费一个，" + i);
                condition1.signal();
                condition2.await();
            }
            lock.unlock();
        }
    }
}

class FoodProductSynchronized {
    volatile int i = 0;

    public synchronized void create() throws InterruptedException {
        while (true) {
            if (i == 0) {
                i++;
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " 生产一个，" + i);
                this.notifyAll();
            } else {
                this.wait();
            }
        }
    }

    public synchronized void eat() throws InterruptedException {
        while (true) {
            if (i == 0) {
                this.wait();
            } else {
                i--;
                Thread.sleep(10);
                System.out.println(Thread.currentThread().getName() + " 消费一个，" + i);
                this.notifyAll();
            }
        }
    }
}