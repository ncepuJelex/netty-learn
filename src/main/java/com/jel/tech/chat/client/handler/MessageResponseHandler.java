package com.jel.tech.chat.client.handler;

import com.jel.tech.chat.protocol.response.MessageResponsePacket;
import com.jel.tech.chat.window.ChatWindow;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MessageResponseHandler extends SimpleChannelInboundHandler<MessageResponsePacket> {

    private ChatWindow window;

    public MessageResponseHandler() {

    }

    public MessageResponseHandler(ChatWindow window) {
        this.window = window;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageResponsePacket messageResponsePacket) {
        String fromUserId = messageResponsePacket.getFromUserId();
        String fromUserName = messageResponsePacket.getFromUserName();
        System.out.println(fromUserId + ":" + fromUserName + " -> " + messageResponsePacket
                .getMessage());

        window.refreshChatArea(fromUserName + ":" + messageResponsePacket.getMessage());
    }

    public void setWindow(ChatWindow window) {
        this.window = window;
    }

    public ChatWindow getWindow() {
        return window;
    }
}
