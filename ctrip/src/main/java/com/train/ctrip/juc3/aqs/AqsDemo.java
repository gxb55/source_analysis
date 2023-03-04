package com.train.ctrip.juc3.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xbguo
 * @createTime 2022年06月18日 14:49:00
 */
public class AqsDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
