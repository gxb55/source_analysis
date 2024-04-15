package com.trip.atguigu.reactor.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class ByteBufTest {
    public static void main(String[] args) {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer(6, 10);
        printByteBufInfo("ByteBufAllocator.buffer(5,10)", buffer);
        buffer.writeBytes(new byte[]{1,2});
        printByteBufInfo("write 2 bytes", buffer);
        buffer.writeInt(100);
        printByteBufInfo("write int 100", buffer);
        buffer.writeBytes(new byte[]{3,4,5});
        printByteBufInfo("write 3 bytes", buffer);
        byte[] read = new byte[buffer.readableBytes()];
        buffer.readBytes(read);
        printByteBufInfo("readBytes(" + buffer.readableBytes() + ")", buffer);

    }

    private static void printByteBufInfo(String step, ByteBuf buffer) {
        System.out.println("------------" + step + "------------");
        System.out.println("readerIndex():" + buffer.readerIndex());
        System.out.println("writerIndex():" + buffer.writerIndex());
        System.out.println("isReadable():" + buffer.isReadable());
        System.out.println("isWritable():" + buffer.isWritable());
        System.out.println("readableBytes():" + buffer.readableBytes());
        System.out.println("writableBytes():" + buffer.writableBytes());
        System.out.println("maxWritableBytes():" + buffer.maxWritableBytes());
        System.out.println("capacity():" + buffer.capacity());
        System.out.println("maxCapacity():" + buffer.maxCapacity());
    }
}
