package com.jel.tech.chat.client.handler;

import com.jel.tech.chat.client.common.WindowRef;
import com.jel.tech.chat.protocol.response.RefreshContactsResponsePacket;
import com.jel.tech.chat.window.ChatWindow;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jelex.xu
 * @create 2020-01-01 17:56
 **/
public class RefreshConcactsResponseHandler extends SimpleChannelInboundHandler<RefreshContactsResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RefreshContactsResponsePacket msg) throws Exception {

        ChatWindow chatWindow = WindowRef.get();
        if (!WindowRef.isVisible()) {
            WindowRef.setVisible(true);
        }
        chatWindow.refreshContacts(msg.getContacts());
    }
}
