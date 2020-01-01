package com.jel.tech.chat.server.handler;

import com.jel.tech.chat.protocol.request.LogoutRequestPacket;
import com.jel.tech.chat.protocol.response.LogoutResponsePacket;
import com.jel.tech.chat.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * 登出请求
 */
@ChannelHandler.Sharable
public class LogoutRequestHandler extends SimpleChannelInboundHandler<LogoutRequestPacket> {
    public static final LogoutRequestHandler INSTANCE = new LogoutRequestHandler();

    private LogoutRequestHandler() {

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LogoutRequestPacket msg) {

        Channel channel = ctx.channel();
        SessionUtil.unBindSession(channel);

        SessionUtil.removeChannel(channel);

        LogoutResponsePacket logoutResponsePacket = new LogoutResponsePacket();
        logoutResponsePacket.setSuccess(true);
        ctx.writeAndFlush(logoutResponsePacket);
        // 刷新好友列表
        SessionUtil.allRefreshContacts();
    }
}
