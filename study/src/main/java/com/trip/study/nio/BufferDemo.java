package com.trip.study.nio;

import java.nio.ByteBuffer;

/**
 * @author xbguo
 * @createTime 2022年09月13日 22:18:00
 *
 * pos=0 lim=1024 cap=1024
 * pos 当前位置
 * lim 写的时候是最大值，读的时候是pos的位置
 */
public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer);
        byteBuffer.putInt(1);

        byteBuffer.putInt(2);
        byteBuffer.putInt(3);
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.remaining());
        byteBuffer.mark();

        byteBuffer.flip();
        System.out.println(byteBuffer);
        System.out.println(byteBuffer.getInt());
        byteBuffer.mark();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.reset();
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.remaining());
        System.out.println(byteBuffer);
    }
}
