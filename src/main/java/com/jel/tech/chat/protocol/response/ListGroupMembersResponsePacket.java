package com.jel.tech.chat.protocol.response;

import com.jel.tech.chat.protocol.Packet;
import com.jel.tech.chat.session.Session;
import lombok.Data;

import java.util.List;

import static com.jel.tech.chat.protocol.command.Command.LIST_GROUP_MEMBERS_RESPONSE;

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;

    @Override
    public Byte getCommand() {

        return LIST_GROUP_MEMBERS_RESPONSE;
    }
}
