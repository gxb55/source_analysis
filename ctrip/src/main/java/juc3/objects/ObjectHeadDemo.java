package juc3.objects;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author xbguo
 * @createTime 2022年06月18日 10:18:00
 * hashcode 和偏向锁无法共存
 * 如果对象调用过hashcode则直接成为轻量级锁，因为对象头保存不了那么多的信息
 * <p>
 * 如果是轻量级锁 00 对象头指向持有锁的线程的 lock record， lock record里面会存放锁对象的hash信息
 * 如果是重量级锁 01 对象头指向堆中monitor对象，monitor 里面会存放hashcode信息
 */
public class ObjectHeadDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        o.hashCode();
        System.out.println(Integer.toHexString(o.hashCode()));
        System.out.println(Integer.toBinaryString(o.hashCode()));
        //110111011010110100001000110011
        //00110111011010110100001000110011
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

    private static void test01() throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
            o.hashCode();
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

    private static void m1() throws InterruptedException {
        Thread.sleep(5000);
        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        o.hashCode();
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
