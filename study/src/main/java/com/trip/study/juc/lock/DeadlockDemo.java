package com.trip.study.juc.lock;

/**
 * 死锁
 */
class DeadLockResource{
    private String str = "hello";
    private String str1 = "hi";


    public void sayHi() throws InterruptedException {
       synchronized (str){
           System.out.println(Thread.currentThread().getName()+" 获得了 "+str);
           Thread.sleep(100);
           synchronized (str1){
               System.out.println(Thread.currentThread().getName()+" 获得了 "+str1);
           }
       }
    }

    public void sayHello() throws InterruptedException {
        synchronized (str1){
            System.out.println(Thread.currentThread().getName()+" 获得了 "+str1);
            Thread.sleep(100);
            synchronized (str){
                System.out.println(Thread.currentThread().getName()+" 获得了 "+str);
            }
        }
    }

}

public class DeadlockDemo {
    public static void main(String[] args) {
        DeadLockResource deadLockResource = new DeadLockResource();
        new Thread(()->{
            try {
                deadLockResource.sayHello();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                deadLockResource.sayHi();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}
