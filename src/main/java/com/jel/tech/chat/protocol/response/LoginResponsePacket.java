package com.jel.tech.chat.protocol.response;

import com.jel.tech.chat.protocol.Packet;
import lombok.Data;

import java.util.ArrayList;

import static com.jel.tech.chat.protocol.command.Command.LOGIN_RESPONSE;

@Data
public class LoginResponsePacket extends Packet {
    private String userId;

    private String userName;

    private boolean success;

    private String reason;

    private ArrayList<String> contacts;

    @Override
    public Byte getCommand() {

        return LOGIN_RESPONSE;
    }
}
