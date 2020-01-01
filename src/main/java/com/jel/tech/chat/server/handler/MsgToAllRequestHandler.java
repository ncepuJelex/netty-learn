package com.jel.tech.chat.server.handler;

import com.jel.tech.chat.protocol.MsgToAllPacket;
import com.jel.tech.chat.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author jelex.xu
 * @create 2020-01-01 18:33
 **/
public class MsgToAllRequestHandler extends SimpleChannelInboundHandler<MsgToAllPacket> {

    public static final MsgToAllRequestHandler INSTANCE = new MsgToAllRequestHandler();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgToAllPacket msg) throws Exception {

        ChannelGroup channels = SessionUtil.getChannels();
        // 发送给所有人
        channels.writeAndFlush(msg);
    }
}
