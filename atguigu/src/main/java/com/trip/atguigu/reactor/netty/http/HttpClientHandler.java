package com.trip.atguigu.reactor.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.HttpContent;
import io.netty.util.CharsetUtil;

/**
 * @author xbguo
 * @date 2024/4/12 17:32
 */
public class HttpClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof HttpContent){
            HttpContent content= (HttpContent) msg;
            ByteBuf byteBuf = content.content();
            System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
            byteBuf.release();
        }
    }
}
