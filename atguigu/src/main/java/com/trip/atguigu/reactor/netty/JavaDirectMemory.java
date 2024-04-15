package com.trip.atguigu.reactor.netty;

import jdk.internal.misc.Unsafe;

import java.nio.ByteBuffer;

/**
 * @author xbguo
 * @date 2024/4/15 19:28
 * @description jdk 直接内层
 */
public class JavaDirectMemory {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocateDirect (1024 * 1024 * 10);

        long l = Unsafe.getUnsafe().allocateMemory(1024 * 1024 * 10);
    }
}
