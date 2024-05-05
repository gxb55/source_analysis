package com.trip.atguigu.reactor.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf o) throws Exception {
        System.out.println("client accept:" + o.toString(CharsetUtil.UTF_8));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String str = "Hello Netty" + System.getProperty("line.separator");
        ByteBufAllocator alloc = ctx.alloc();
        for (int i = 0; i < 1; i++) {
            String msg = i + ":" + str;
            ByteBuf buffer = alloc.buffer(msg.length());
            buffer.writeBytes(msg.getBytes());
            ctx.writeAndFlush(buffer);
        }
        System.out.println("发送完毕！");
        //  ctx.writeAndFlush(Unpooled.copiedBuffer("Hello Netty",CharsetUtil.UTF_8));
    }
}
