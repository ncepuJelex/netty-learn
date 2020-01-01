package com.jel.tech.chat.client.handler;

import com.jel.tech.chat.client.common.LoginFrameRef;
import com.jel.tech.chat.protocol.response.LoginResponsePacket;
import com.jel.tech.chat.session.Session;
import com.jel.tech.chat.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()) {
            System.out.println("[" + userName + "]登录成功，userId 为: " + loginResponsePacket.getUserId());
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());

            // 隐藏登录界面
            LoginFrameRef.get().setVisible(false);
//            // 启动聊天窗口
//            ChatWindow chatWindow = new ChatWindow(ctx.channel());
//            WindowRef.set(new WindowRef(chatWindow));
        } else {
            System.out.println("[" + userName + "]登录失败，原因：" + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("客户端连接被关闭!");
    }
}
