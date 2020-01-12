package com.jel.tech.chat.client.handler;

import com.jel.tech.chat.client.common.WindowRef;
import com.jel.tech.chat.protocol.response.RefreshContactsResponsePacket;
import com.jel.tech.chat.session.Attributes;
import com.jel.tech.chat.window.ChatWindow;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author jelex.xu
 * @create 2020-01-01 17:56
 **/
public class RefreshContactsResponseHandler extends SimpleChannelInboundHandler<RefreshContactsResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RefreshContactsResponsePacket msg) throws Exception {

        ChatWindow chatWindow = ctx.channel().attr(Attributes.CHAT_WINDOW_ATTRIBUTE_KEY).get();
        if (!chatWindow.isVisible()) {
            chatWindow.setVisible(true);
        }
        chatWindow.refreshContacts(msg.getContacts());
    }
}
