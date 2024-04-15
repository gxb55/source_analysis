package com.trip.atguigu.reactor.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author xbguo
 * @date 2024/4/15 17:08
 */
public class RequestSampleHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String data = ((ByteBuf) (msg)).toString(CharsetUtil.UTF_8);
        ResponseSample ok = new ResponseSample("ok", data, System.currentTimeMillis());
        // 从tail节点往前写
        ctx.channel().writeAndFlush(ok);
        // 从当前节点往前写
        ctx.writeAndFlush(ok);
    }

}
