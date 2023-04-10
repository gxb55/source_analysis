package com.trip.study.lock.distributedlock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年10月11日 21:16:00
 */
public class RedisLock {
    public static void main(String[] args) throws InterruptedException {
        RedisLock redisLock = new RedisLock();
        RedissonClient client = redisLock.getLock();
        RLock lock = client.getLock("lock");

        lock.tryLock(1,TimeUnit.MILLISECONDS);
        lock.unlock();

        new Thread(()->{
            lock.lock();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        },"T1").start();
        new Thread(()->{

        },"T2").start();
        Thread.sleep(1);
        lock.lock();
        lock.tryLock(100, TimeUnit.SECONDS);
        lock.unlock();
    }

    public RedissonClient getLock() {
        //编写配置
        Config config = new Config();
        //单节点模式
        config.useSingleServer().setAddress("redis://" + "192.168.10.100" + ":" + 6379);
        return Redisson.create(config);
    }
}
