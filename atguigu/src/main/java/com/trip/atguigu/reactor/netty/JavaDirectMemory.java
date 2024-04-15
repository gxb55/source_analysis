package com.trip.atguigu.reactor.netty;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * @author xbguo
 * @date 2024/4/15 19:28
 * @description jdk 直接内层
 */
public class JavaDirectMemory {
    private static Unsafe unsafe = null;

    static {
        Field getUnsafe = null;
        try {
            getUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            getUnsafe.setAccessible(true);
            unsafe = (Unsafe) getUnsafe.get(null);
        } catch (Exception e) {

        }

    }

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 1024 * 10);
        int bytes = 1024;
        long l = unsafe.allocateMemory(bytes);
        unsafe.freeMemory(bytes);

        ByteBuffer byteBuffer = ByteBuffer.allocate(bytes);
        byteBuffer.put("nihao".getBytes());
        ByteBuf byteBuf = Unpooled.buffer(bytes);

    }
}
