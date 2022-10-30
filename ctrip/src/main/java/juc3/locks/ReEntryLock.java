package juc3.locks;

/**
 * @author xbguo
 * @createTime 2022年06月09日 21:25:00
 */
public class ReEntryLock {
    public static void main(String[] args) throws InterruptedException {
        ReEntryLock entryLock = new ReEntryLock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                entryLock.m1();
            },"t"+i).start();
        }
        Thread.sleep(1000);
    }

    public synchronized void m1() {
        System.out.println(Thread.currentThread().getName() + "  m1 come in");
        m2();
    }

    public synchronized void m2() {
        System.out.println(Thread.currentThread().getName() + "  m2 come in");
        m3();
    }

    public synchronized void m3() {
        System.out.println(Thread.currentThread().getName() + "  m3 come in");
        System.out.println("-------------");
        System.out.println();
    }
}
