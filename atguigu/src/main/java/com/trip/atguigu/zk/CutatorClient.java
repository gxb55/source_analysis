package com.trip.atguigu.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class CutatorClient {
    static String path = "/lock";
    static String connectString = "192.168.3.96:2181,192.168.3.97:2181,192.168.3.98:2181";
    static int connectionTimeout = 3000;
    static int seddionTimeout = 3000;

    public static void main(String[] args) throws InterruptedException {
        InterProcessLock lock1 = new InterProcessMutex(getCuratorFramework(), path);
        InterProcessLock lock2 = new InterProcessMutex(getCuratorFramework(), path);
        new Thread(() -> {
            try {
                lock1.acquire();
                System.out.println(Thread.currentThread().getName() + "获取锁在工作。。。");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "工作结束。。。");
                lock1.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        Thread.sleep(1000);

        new Thread(() -> {
            try {
                lock2.acquire();
                System.out.println(Thread.currentThread().getName() + "获取锁在工作。。。");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "工作结束。。。");
                lock2.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
       // test(lock1, lock2);
    }

    private static void test(InterProcessLock lock1, InterProcessLock lock2) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock1.acquire();
                    System.out.println("线程 1 获取锁");
                    // 测试锁重入
                    lock1.acquire();
                    System.out.println("线程 1 再次获取锁");
                    Thread.sleep(5 * 1000);
                    lock1.release();
                    System.out.println("线程 1 释放锁");
                    lock1.release();
                    System.out.println("线程 1 再次释放锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 获取锁对象
                try {
                    lock2.acquire();
                    System.out.println("线程 2 获取锁");
                    // 测试锁重入
                    lock2.acquire();
                    System.out.println("线程 2 再次获取锁");
                    Thread.sleep(5 * 1000);
                    lock2.release();
                    System.out.println("线程 2 释放锁");
                    lock2.release();
                    System.out.println("线程 2 再次释放锁");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    private static CuratorFramework getCuratorFramework() {
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);


        CuratorFramework build = CuratorFrameworkFactory.builder().connectString(connectString)
                .connectionTimeoutMs(connectionTimeout)
                .sessionTimeoutMs(seddionTimeout)
                .retryPolicy(policy).build();
        build.start();
        return build;


    }
}
