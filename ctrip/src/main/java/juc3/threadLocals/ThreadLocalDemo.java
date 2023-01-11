package juc3.threadLocals;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年07月03日 09:36:00
 */
public class ThreadLocalDemo {
    static final TransmittableThreadLocal<Map<String, String>> transmittableThreadLocal = new TransmittableThreadLocal<>();

    static final ThreadLocal<Map<String, String>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) {
        transmittableThreadLocal.set(new HashMap<>());
        transmittableThreadLocal.get().put("CC", "CC");
        threadLocal.get().put("ThreadLocal_CC", "ThreadLocal_CC");
        System.out.println(transmittableThreadLocal.get().get("CC"));
        System.out.println(threadLocal.get().get("ThreadLocal_CC"));
        new Thread(() -> {
            transmittableThreadLocal.set(new HashMap<>());
            transmittableThreadLocal.get().put(Thread.currentThread().getName(), "AA");
            System.out.println(transmittableThreadLocal.get().get(Thread.currentThread().getName()));
        }, "T1").start();
        new Thread(() -> {
            transmittableThreadLocal.set(new HashMap<>());
            transmittableThreadLocal.get().put(Thread.currentThread().getName(), "BB");
            System.out.println(transmittableThreadLocal.get().get(Thread.currentThread().getName()));
        }, "T2").start();

        Thread thread = new Thread(TtlRunnable.get(() -> {
            TransmittableThreadLocal<Map<String, String>> threadLocal1 = new TransmittableThreadLocal<>();
            threadLocal1.set(new HashMap<>());
            System.out.println(transmittableThreadLocal.get().get("CC"));
        }), "T#");
        System.out.println(thread);


        System.out.println("end");
    }
}
