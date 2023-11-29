package com.trip.study.juc.longaddr;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author xbguo
 * @createTime 2023年11月26日 17:39:00
 */
public class LongAdderDemo {
    private static ThreadLocal<Map<String,String>> threadLocal =ThreadLocal.withInitial(()->new HashMap<>());
    public static void main(String[] args) throws InterruptedException {
        threadLocal.set(new HashMap<>());
        NumberUtil numberUtil =new NumberUtil();
        int count=50;
        int sum=100000;
        CountDownLatch countDownLatch =new CountDownLatch(count);
        long t=System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread(()->{
                for (int j = 0; j < sum; j++) {
                    numberUtil.addNumber();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        long t1=System.currentTimeMillis();
        System.out.println("耗时："+(t1-t)+":"+ numberUtil.number);


        CountDownLatch countDownLatch1 =new CountDownLatch(count);
        long t2=System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread(()->{
                for (int j = 0; j < sum; j++) {
                    numberUtil.add_LongAccumulator();
                }
                countDownLatch1.countDown();
            }).start();
        }
        countDownLatch1.await();
        System.out.println("耗时："+(System.currentTimeMillis()-t2)+":"+ numberUtil.accumulator.get());

        CountDownLatch countDownLatch2 =new CountDownLatch(count);
        long t3=System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            new Thread(()->{
                for (int j = 0; j < sum; j++) {
                    numberUtil.add_LongAdder();
                }
                countDownLatch2.countDown();
            }).start();
        }
        countDownLatch2.await();
        System.out.println("耗时："+(System.currentTimeMillis()-t3)+":"+ numberUtil.longAdder);
    }
}
class NumberUtil{
    int number=0;
    public synchronized void addNumber(){
        number++;
    }
    LongAdder longAdder =new LongAdder();
    public void add_LongAdder(){
        longAdder.increment();
    }
    AtomicInteger atomicInteger =new AtomicInteger();
    public void add_AtomicInteger(){
        atomicInteger.addAndGet(1);
    }
    LongAccumulator accumulator =new LongAccumulator((x,y)->x+y,0);
    public void add_LongAccumulator(){
        accumulator.accumulate(1);
    }
}
