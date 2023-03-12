package com.trip.study.base.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xbguo
 * @createTime 2023年03月05日 23:32:00
 */
public class CyclicbarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicbarrier = new CyclicBarrier(2);
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"我已到达");
                cyclicbarrier.await();
                System.out.println("开始开会！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            try {
                cyclicbarrier.await();
                System.out.println(Thread.currentThread().getName()+"我已到达");
                System.out.println("开始开会！");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }).start();
        System.out.println(1);
        Thread.sleep(5000);
    }
}
