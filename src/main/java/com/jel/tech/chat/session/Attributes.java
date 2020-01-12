package com.jel.tech.chat.session;

import com.jel.tech.chat.window.ChatWindow;
import com.jel.tech.chat.window.LoginFrame;
import io.netty.util.AttributeKey;

public interface Attributes {

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");

    /**
     * 登录界面
     */
    AttributeKey<LoginFrame> LOGIN_FRAME_ATTRIBUTE_KEY = AttributeKey.newInstance("loginFrame");

    /**
     * 聊天界面
     */
    AttributeKey<ChatWindow> CHAT_WINDOW_ATTRIBUTE_KEY = AttributeKey.newInstance("chatWindow");


}
