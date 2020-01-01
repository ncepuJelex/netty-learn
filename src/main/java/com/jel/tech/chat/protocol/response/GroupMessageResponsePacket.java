package com.jel.tech.chat.protocol.response;

import com.jel.tech.chat.protocol.Packet;
import com.jel.tech.chat.session.Session;
import lombok.Data;

import static com.jel.tech.chat.protocol.command.Command.GROUP_MESSAGE_RESPONSE;

@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;

    private Session fromUser;

    private String message;

    @Override
    public Byte getCommand() {

        return GROUP_MESSAGE_RESPONSE;
    }
}
