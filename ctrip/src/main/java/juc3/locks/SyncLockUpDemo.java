package juc3.locks;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author xbguo
 * @createTime 2022年12月24日 17:47:00
 * <p>
 * -XX:BiasedLockingStartupDelay=0
 * 偏向锁起始时间
 * <p>
 * java -XX:+PrintFlagsFinal -version | findstr BiasedLocking
 * 偏向锁相关jvm配置
 */
public class SyncLockUpDemo {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(thread.getPriority());
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

    }
}
