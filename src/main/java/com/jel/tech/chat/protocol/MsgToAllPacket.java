package com.jel.tech.chat.protocol;

import lombok.Data;

import static com.jel.tech.chat.protocol.command.Command.MSG_TO_ALL;

/**
 * @author jelex.xu
 * @create 2020-01-01 18:26
 **/
@Data
public class MsgToAllPacket extends Packet {

    /**
     * 发送人id 和 名称
     */
    private String userId;
    private String userName;

    // 发送消息
    private String message;

    @Override
    public Byte getCommand() {
        return MSG_TO_ALL;
    }
}
