package com.jel.tech.chat.protocol.request;

import com.jel.tech.chat.protocol.Packet;
import lombok.Data;

import static com.jel.tech.chat.protocol.command.Command.QUIT_GROUP_REQUEST;

@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommand() {

        return QUIT_GROUP_REQUEST;
    }
}
