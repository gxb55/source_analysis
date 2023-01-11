package com.trip.study.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo
 * @createTime 2022年11月27日 10:04:00
 * 生产者消费者
 * 生产 - 消费
 */
public class ProductAndConsumerLock {
    int cur = 0;
    Lock lock = new ReentrantLock();
    Condition productCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();

    public void productFood() {
        lock.lock();
        try {
            while (cur > 0) {
                productCondition.await();
            }
            cur = cur + 1;
            System.out.println(Thread.currentThread().getName() + "生产一个：" + cur);
            consumerCondition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void consumerFood() {
        lock.lock();
        try {
            while (cur <= 0) {
                consumerCondition.await();
            }
            cur = cur - 1;
            System.out.println(Thread.currentThread().getName() + "消费一个：" + cur);
            productCondition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ProductAndConsumerLock productAndConsumerLock = new ProductAndConsumerLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                productAndConsumerLock.productFood();
            }, "P" + i).start();
        }
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                productAndConsumerLock.consumerFood();
            }, "C" + i).start();
        }
    }
}
