package juc4.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;

public class ThreadLocalDemo1 {
    private static final ThreadLocal<String> thread=ThreadLocal.withInitial(()->"");
    private static final InheritableThreadLocal<String> inheritableThreadLocal=new InheritableThreadLocal<>();
    private static final TransmittableThreadLocal<String> threadLocal=new TransmittableThreadLocal<>();
    public static void main(String[] args) {
        //m1();
        //m2();
        threadLocal.set("main");
        System.out.println(threadLocal.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            threadLocal.set("aa");
            System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
        }).start();
        System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
    }

    private static void m2() {
        inheritableThreadLocal.set("main");
        System.out.println(inheritableThreadLocal.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":"+inheritableThreadLocal.get());
            inheritableThreadLocal.set("aa");
            System.out.println(Thread.currentThread().getName()+":"+inheritableThreadLocal.get());
        }).start();
        System.out.println(Thread.currentThread().getName()+":"+inheritableThreadLocal.get());
    }

    private static void m1() {
        thread.set("main");
        System.out.println(thread.get());
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+":"+thread.get());
        }).start();
    }
}
