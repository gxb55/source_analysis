package com.trip.atguigu.test;

import java.util.concurrent.Semaphore;

/**
 * @author xbguo
 * @createTime 2022年05月10日 22:36:00
 */
public class Demo_Semaphore {
    static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                login();
                //loginOut();
            }, "e" + i).start();
        }




    }

    private static void loginOut() {
        try {
            System.out.println(Thread.currentThread().getName() + "登出成功");
            semaphore.release();
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void login() {
        try {
            boolean b = semaphore.tryAcquire();
            if(b){
                System.out.println(Thread.currentThread().getName() + "登录成功");
            }else{
               // System.out.println(Thread.currentThread().getName() + "登录失败");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
