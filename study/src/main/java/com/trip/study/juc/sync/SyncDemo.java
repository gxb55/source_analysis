package com.trip.study.juc.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone {
    public static synchronized void sendMsg() {
        try {
            Thread.sleep(5000);
        }catch (Exception e){

        }
        System.out.println("sendSms");
    }

    public synchronized void sendEmail() {
        System.out.println("sendEmail");
    }

    public void sayHello() {
        System.out.println("say hello");
    }
}


/**
 *
 *
 *
 * 同步方法锁this
 * 静态同步方法锁类对象，
 *
 *
 * 八锁
 * 1.标准访问，先打印短信还是邮件
 * sendSms
 * sendEmail
 * 2.停4秒后在短信方法内，先打印短信还是邮件
 * sendSms
 * sendEmail
 * 3.新增普通的hello方法，是先打短信还是hello
 * getHello
 * sendSMS
 * 4.现在有两部手机，先打印短信还是邮件
 * sendEmail
 * sendSMS
 * 5.两个静态同步方法，1部手机，先打印短信还是邮件
 * sendSms
 * sendEmail
 * 6.两个静态同步方法，两部手机，先打印短信还是邮件
 * sendSms
 * sendEmail
 * 7.1个静态同步方法，1个普通同步方法，1部手机 ，先打印短信还是邮件
 * sendEmail
 * sendSms
 * 8.1个静态同步方法，1个普通同步方法，两部手机，先打印短信还是邮件
 * sendEmail
 * sendSms
 */
public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone1 = new Phone();
        new Thread(() -> {
            Phone.sendMsg();
           // phone.sendMsg();
        }, "AA").start();
        Thread.sleep(100);
        new Thread(() -> {
            phone1.sendEmail();
        }, "AA").start();

        Lock lock = new ReentrantLock(true);
    }
}
