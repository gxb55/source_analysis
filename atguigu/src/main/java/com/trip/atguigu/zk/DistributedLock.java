package com.trip.atguigu.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Administrator
 * 打印日志仔细看
 * a:t1::[seq0000000108]
 * t1获取锁在工作。。。                              t1创建108
 * <p>
 * t2::/lock/seq0000000109 ::/lock/seq0000000108  t2创建 109 监听 108
 * <p>
 * t3::/lock/seq0000000110 ::/lock/seq0000000109  t3创建110  监听 109
 * <p>
 * t1 108删除 唤醒 t2 t3，他们对比删除的节点是否是自己要等的，如果是自己就获取到锁了
 */
public class DistributedLock {
    static String host = "192.168.3.96:2181,192.168.3.97:2181,192.168.3.98:2181";
    ZooKeeper zkCli = null;
    String path = "/lock";
    CountDownLatch countDownLatch = new CountDownLatch(1);
    // 当前 client 创建的子节点
    private String currentNode;
    // 当前节点的上一个节点
    private String waitPath;

    public DistributedLock() throws Exception {
        zkCli = new ZooKeeper(host, 2000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getType() == Event.EventType.NodeDeleted && watchedEvent.getPath().equals(waitPath)) {
                    //System.out.println(watchedEvent.getPath());
                    countDownLatch.countDown();
                }
            }
        });
        Stat exists = zkCli.exists(path, false);
        if (exists == null) {
            zkCli.create(path, "lock".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
    }

    /**
     * 在lock下面创建带序号的临时节点
     * 1.如果你是第一个则你获取到锁
     * 2.如果你不是第一个则说明你没有获取到锁
     */
    public void zkLock() throws Exception {
        currentNode = zkCli.create("/lock/seq", "seq".getBytes(StandardCharsets.UTF_8), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        List<String> children = zkCli.getChildren(path, false);

        // 如果只有一个节点则说明是我刚上锁的节点，直接获得锁
        if (children.size() == 1) {
            System.out.println("a:" + Thread.currentThread().getName() + "::" + children);
            // 当前线程尝试获取，获取不到就等着
            return;
        } else {
            Collections.sort(children, Comparator.naturalOrder());
            //currentPath 是全的比如 /lock/seq0000001
            String currentIndex = currentNode.substring(6);
            int i = children.indexOf(currentIndex);
            if (i == -1) {
                System.out.println("数据异常");
                return;
            } else if (i == 0) {
                System.out.println("b:" + Thread.currentThread().getName() + "::" + children);
                // 当前节点最小，获取到了锁
                return;
            } else {

                waitPath = path + "/" + children.get(i - 1);
                zkCli.getData(waitPath, true, new Stat());
                System.out.println(Thread.currentThread().getName() + "::" + currentNode + " ::" + waitPath);
                // 当前线程尝试获取，获取不到就等着
                countDownLatch.await();
            }
        }
    }

    /**
     * 获取到锁的节点才可以解锁，解锁对应的实质是删除带序号的临时节点
     */
    public void zkUnLock() throws InterruptedException, KeeperException {
        zkCli.delete(currentNode, -1);
        System.out.println(Thread.currentThread().getName() + "工作完毕！");
    }

    public static void main(String[] args) throws Exception {
        DistributedLock lock = new DistributedLock();
        DistributedLock lock1 = new DistributedLock();
        DistributedLock lock2 = new DistributedLock();


        new Thread(() -> {
            try {
                lock.zkLock();
                System.out.println(Thread.currentThread().getName() + "获取锁在工作。。。");
                Thread.sleep(5000);
                lock.zkUnLock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();

        Thread.sleep(1000);

        new Thread(() -> {
            try {
                lock1.zkLock();
                System.out.println(Thread.currentThread().getName() + "获取锁在工作。。。");
                Thread.sleep(5000);
                lock1.zkUnLock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
        Thread.sleep(1000);

        new Thread(() -> {
            try {
                lock2.zkLock();
                System.out.println(Thread.currentThread().getName() + "获取锁在工作。。。");
                Thread.sleep(5000);
                lock2.zkUnLock();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t3").start();


    }
}
