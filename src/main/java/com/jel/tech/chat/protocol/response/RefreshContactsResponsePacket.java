package com.jel.tech.chat.protocol.response;

import com.jel.tech.chat.protocol.Packet;
import lombok.Data;

import java.util.ArrayList;

import static com.jel.tech.chat.protocol.command.Command.REFRESH_CONTACTS;

/**
 * @author jelex.xu
 * @create 2020-01-01 17:56
 **/
@Data
public class RefreshContactsResponsePacket extends Packet {

    private ArrayList<String> contacts;

    @Override
    public Byte getCommand() {
        return REFRESH_CONTACTS;
    }
}
