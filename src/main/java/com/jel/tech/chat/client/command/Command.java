package com.jel.tech.chat.client.command;

import com.jel.tech.chat.protocol.Packet;
import io.netty.channel.Channel;


/**
 * @author jelex.xu
 * @create 2020-01-01 13:35
 **/
public interface Command<T> {

    void execute(T packet, Channel channel);
}
