package com.jel.tech.chat.protocol.request;


import com.jel.tech.chat.protocol.Packet;

import static com.jel.tech.chat.protocol.command.Command.HEARTBEAT_REQUEST;

public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommand() {
        return HEARTBEAT_REQUEST;
    }
}
