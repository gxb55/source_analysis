package juc3.objects;

/**
 * @author xbguo
 * @createTime 2022年06月18日 10:50:00
 */
public class LockDemo {
    public static void main(String[] args) {
        /**
         * 锁消除
         * 锁粗化
         * jit 及时编译器
         */
        // lockClear();
        lockCoarsen();
    }

    private static void lockCoarsen() {
        Object object = new Object();
        synchronized (object) {
            System.out.println("111");
        }
        synchronized (object) {
            System.out.println("222");
        }
        synchronized (object) {
            System.out.println("333");
        }
        synchronized (object) {
            System.out.println("444");
        }
    }

    private static void lockClear() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                sayHi();
            }, "T" + i).start();
        }
    }

    static Object objectLock = new Object();

    public static void sayHi() {
        Object object = new Object();
        synchronized (object) {
            System.out.println("sayHi " + Thread.currentThread().getName());
        }
    }
}
