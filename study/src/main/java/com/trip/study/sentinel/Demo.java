package com.trip.study.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;

public class Demo {
    @SentinelResource(value = "hello", fallback = "helloFallback")
    public String hello(long s) {
        if (s < 0) {
            throw new IllegalArgumentException("invalid arg");
        }
        return String.format("Hello at %d", s);
    }

    /**
     * sentinel demo
     *
     */
    public static void foo() {
        Entry entry = null;
        try {
            entry = SphU.entry("abc");
        } catch (BlockException e) {
            Tracer.trace(e);
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    public static void main(String[] args) {
        foo();
    }
}
