package com.trip.study.juc.threadlocal;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年11月28日 22:03:00
 */
public class ThreadLocalDemo1 {
     ThreadLocal<Map<String,String>> threadLocal = ThreadLocal.withInitial(() -> new HashMap<>());

    public static void main(String[] args) throws InterruptedException {
        //CN1\xbguo
        ThreadLocalDemo1 threadLocalDemo1 =new ThreadLocalDemo1();
        threadLocalDemo1.sayHi();
        threadLocalDemo1.sayHello();
        threadLocalDemo1.threadLocal.get().put("ss","ss");
        System.gc();
        Thread.sleep(2000);
        System.out.println(threadLocalDemo1);
        System.out.println(threadLocalDemo1.threadLocal);
        System.out.println(Thread.currentThread());
    }
    public void sayHi(){
        ThreadLocal<Map<String,String>> threadLocal = ThreadLocal.withInitial(() -> new HashMap<>());
        threadLocal.get().put("me","aa");
    }
    public void sayHello(){
        ThreadLocal<Map<String,String>> threadLocal = ThreadLocal.withInitial(() -> new HashMap<>());
        threadLocal.get().put("me1111","aa1");
    }
}
