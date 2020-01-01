package com.jel.tech.chat.client.handler;

import com.jel.tech.chat.client.common.WindowRef;
import com.jel.tech.chat.protocol.MsgToAllPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jelex.xu
 * @create 2020-01-01 18:31
 **/
public class MsgToAllResponseHandler extends SimpleChannelInboundHandler<MsgToAllPacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MsgToAllPacket msg) throws Exception {

        WindowRef.get().refreshChatArea(msg.getMessage());
    }
}
