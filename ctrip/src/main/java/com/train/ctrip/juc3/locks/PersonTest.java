package com.train.ctrip.juc3.locks;

import java.util.Map;

/**
 * @author xbguo
 * @date 2023/3/1 19:39
 */
public class PersonTest {
    public void sayHi() throws InterruptedException {
        synchronized (this){
            System.out.println(1);
            Thread.sleep(1000);
        }
    }

    public void sayHello() throws InterruptedException {
        synchronized (PersonTest.class){
            System.out.println(1);
            Thread.sleep(2000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            PersonTest personTest = new PersonTest();
            try {
                personTest.sayHi();
               //personTest.sayHello();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            PersonTest personTest = new PersonTest();
            try {
                personTest.sayHi();
               // personTest.sayHello();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Thread.sleep(5000);
    }
}
