package com.jel.tech.chat.protocol.response;


import com.jel.tech.chat.protocol.Packet;

import static com.jel.tech.chat.protocol.command.Command.HEARTBEAT_RESPONSE;

public class HeartBeatResponsePacket extends Packet {
    @Override
    public Byte getCommand() {
        return HEARTBEAT_RESPONSE;
    }
}
