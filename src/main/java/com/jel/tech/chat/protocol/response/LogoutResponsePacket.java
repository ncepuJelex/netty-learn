package com.jel.tech.chat.protocol.response;

import com.jel.tech.chat.protocol.Packet;
import lombok.Data;

import static com.jel.tech.chat.protocol.command.Command.LOGOUT_RESPONSE;

@Data
public class LogoutResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {

        return LOGOUT_RESPONSE;
    }
}
