package com.trip.atguigu.reactor.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class MyByteToMessageDecoder extends ByteToMessageDecoder {
    /**
     * 14
     * 魔数
     * 协议版本号
     * 消息类型
     * 消息状态
     * 保留字段
     * 消息长度
     * 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
     *
     * +---------------------------------------------------------------+
     *
     * | 状态 1byte |        保留字段 4byte     |      数据长度 4byte     |
     *
     * @param ctx           the {@link ChannelHandlerContext} which this {@link ByteToMessageDecoder} belongs to
     * @param in            the {@link ByteBuf} from which to read data
     * @param out           the {@link List} to which decoded messages should be added
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
            if(in.readableBytes()<14){
                return;
            }
            in.markReaderIndex();// 标记读指针位置
            in.skipBytes(2);//跳过魔术
        in.skipBytes(1);//跳过协议版本号
        byte b = in.readByte();
        in.skipBytes(1);//跳过报文类型
        in.skipBytes(1);//跳过状态字段
        in.skipBytes(4);//跳过保留字段 解码
        int dataLength = in.readInt();
        if(in.readableBytes()<dataLength){
            in.resetReaderIndex();// 重置 byteBug读指针位置
            return;
        }
        byte[] data = new byte[dataLength];
        in.readBytes(data);
       /* SerializeService serializeService = getSerializeServiceByType(serializeType);

        Object obj = serializeService.deserialize(data);

        if (obj != null) {

            out.add(obj);

        }*/
    }
}
