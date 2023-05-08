package com.train.ctrip.juc3.threadLocals;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xbguo
 * @createTime 2022年07月03日 09:36:00
 */
public class ThreadLocalDemo {
    static final TransmittableThreadLocal<Map<String, String>> transmittableThreadLocal = new TransmittableThreadLocal<>();
    static final TransmittableThreadLocal<Map<String, String>> transmittableThreadLocal2 = new TransmittableThreadLocal<>();

    static final ThreadLocal<Map<String, String>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) {
        Thread thread = new Thread();

        test();
    }

    public void sayHello(String val) {
        test();
    }

    private static void test2(String val) {
        ThreadLocal<Map<String, String>> threadLocal = ThreadLocal.withInitial(HashMap::new);
        HashMap<String, String> map = new HashMap<>();
        map.put("k", val);
        threadLocal.set(map);
        System.out.println(val);
    }

    static ExecutorService executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(1));

    private static void test() {
        transmittableThreadLocal.set(new HashMap<>());
        transmittableThreadLocal.get().put("CC", "CC");

        System.out.println(transmittableThreadLocal.get().get("CC"));
        for (int i = 0; i < 10; i++) {
            transmittableThreadLocal.get().put("CC", "CC" + i);
            executorService.execute(() -> {
                System.out.println(transmittableThreadLocal.get().get("CC"));
            });
        }


        System.out.println(transmittableThreadLocal.get().get("CC"));

        System.out.println("end");
    }
}
