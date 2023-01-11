package com.trip.study.base.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo
 * @createTime 2022年11月27日 11:02:00
 */
public class ABCLock {
    Lock lock = new ReentrantLock();
    int cur = 1;
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            while (cur != 1) {
                conditionA.await();
            }
            System.out.println(cur);
            cur = 2;
            conditionB.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        lock.lock();
        try {
            while (cur != 2) {
                conditionB.await();
            }
            System.out.println(cur);
            cur = 3;
            conditionC.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void printC() {
        lock.lock();
        try {
            while (cur != 3) {
                conditionC.await();
            }
            System.out.println(cur);
            cur = 1;
            conditionA.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ABCLock abcLock = new ABCLock();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                abcLock.printC();
            }, "C" + i).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                abcLock.printA();
            }, "A" + i).start();
        }

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                abcLock.printB();
            }, "B" + i).start();
        }
    }
}
