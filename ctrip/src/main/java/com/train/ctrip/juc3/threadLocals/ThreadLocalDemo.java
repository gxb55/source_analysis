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

    static final ThreadLocal<Map<String, String>> threadLocal = ThreadLocal.withInitial(HashMap::new);

    public static void main(String[] args) {
        Thread thread = new Thread();

        executorService.execute(() -> {
            System.out.println(1);
        });
        executorService.execute(() -> {
            System.out.println(2);
        });
        TransmittableThreadLocal<Map<String, String>> transmittableThreadLocal1 = new TransmittableThreadLocal(){
            @Override
            protected Object childValue(Object parentValue) {
                return super.childValue(parentValue);
            }
        };
        System.out.println(Thread.currentThread());
        transmittableThreadLocal1.set(new HashMap<>());
        transmittableThreadLocal1.get().put("1", "1");
        executorService.execute(() -> {
            System.out.println(transmittableThreadLocal1.get().get("CC"));
        });


        TransmittableThreadLocal<Map<String, String>> transmittableThreadLocal2 = new TransmittableThreadLocal<>();
        transmittableThreadLocal2.set(new HashMap<>());
        transmittableThreadLocal2.get().put("1", "2");
        executorService.execute(() -> {
            System.out.println(transmittableThreadLocal2.get().get("1"));
        });
        executorService.shutdown();
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

        executorService.execute(() -> {
            System.out.println(transmittableThreadLocal.get().get("CC"));
        });

        System.out.println(transmittableThreadLocal.get().get("CC"));

        System.out.println("end");
    }
}
