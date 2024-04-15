package com.trip.atguigu.reactor.netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author xbguo
 * @date 2024/4/15 17:04
 */
public class ResponseSampleEncoder extends MessageToByteEncoder<ResponseSample> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ResponseSample msg, ByteBuf byteBuf) throws Exception {
        if(msg!=null){
            byteBuf.writeBytes(msg.getCode().getBytes());
            byteBuf.writeBytes(msg.getData().getBytes());
            byteBuf.writeLong(msg.getTimestamp());
        }
    }

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        super.write(ctx, msg, promise);
    }
}
