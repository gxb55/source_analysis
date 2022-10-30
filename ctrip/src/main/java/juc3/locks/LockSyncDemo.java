package juc3.locks;

/**
 * @author xbguo
 * @createTime 2022年06月05日 18:04:00
 */
public class LockSyncDemo {
    Object object = new Object();

    public static void main(String[] args) {

    }

    /**
     *  monitor enter
     *  monitor exit
     */
    public void m1() {
        synchronized (object) {
            System.out.println("come in!");
        }
    }

    /**
     * ACC_SYNCHRONIZED
     */
    public synchronized void m2() {
        System.out.println("m2 come in!");
    }

    /**
     * ACC_STATIC
     * ACC_SYNCHRONIZED
     */
    public static synchronized void m3() {
        System.out.println("static m3 come in!");
    }
}
