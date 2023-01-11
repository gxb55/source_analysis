package juc3.threadLocals;

import com.alibaba.ttl.TransmittableThreadLocal;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author xbguo
 * @createTime 2022年12月18日 18:52:00
 */
class Mydata {

    @Override
    protected void finalize() throws Throwable {

        System.out.println(this + " invoke finalize");
    }
}

public class ReferenceDemo {
    static TransmittableThreadLocal<HashMap> threadLocal = new TransmittableThreadLocal<>();
    static ThreadLocal<HashMap> threadLocal1 = ThreadLocal.withInitial(() -> new HashMap());
    private static SoftReference<Mydata> softReference;

    public static void main(String[] args) throws InterruptedException {
        threadLocalTest();
        System.gc();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread());
    }

    private static void threadLocalTest() {
        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(2);
        System.out.println(threadLocal2);
        System.out.println(threadLocal2.get());
    }

    private static void weakReferenceDemo() throws InterruptedException {
        WeakReference weakReference = new WeakReference(new Mydata());
        System.out.println(weakReference.get());
        threadLocal1.get().put("A", "A");
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("内存够用：" + weakReference.get());
        System.out.println("内存够用：" + threadLocal1.get());
    }

    private static void softReferenceDemo() throws InterruptedException {
        softReference = new SoftReference<Mydata>(new Mydata());
        threadLocal.set(new HashMap());
        threadLocal.get().put("A", "A");
        System.out.println("正常输出：" + softReference.get());
        System.out.println("TransmittableThreadLocal：" + threadLocal.get());
        System.gc();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("内存够用：" + softReference.get());
        System.out.println("内存够用TransmittableThreadLocal：" + threadLocal.get());
        try {
            byte[] bytes = new byte[1024 * 1024 * 14];
        } catch (Exception e) {

        } finally {
            System.out.println("内存不够用TransmittableThreadLocal：" + threadLocal.get());
            System.out.println("内存不够用：" + softReference.get());
        }
    }
}
