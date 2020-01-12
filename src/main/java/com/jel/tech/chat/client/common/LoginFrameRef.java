package com.jel.tech.chat.client.common;

import com.jel.tech.chat.window.LoginFrame;

/**
 * @author jelex.xu
 * @create 2020-01-01 20:28
 * @description 通过channel.attr(...) => get/set 替换此类功能
 **/
@Deprecated
public class LoginFrameRef {

    private static LoginFrameRef ref0;

    private LoginFrame loginFrame;

    public LoginFrameRef(LoginFrame frame) {
        this.loginFrame = frame;
    }

    // invoke after set(...)
    public static LoginFrame get() {
        if (ref0 == null) {
            return null;
        }
        return ref0.loginFrame;
    }

    public static void set(LoginFrameRef ref) {

        if (ref != null && ref0 == null) {
            ref0 = ref;
        }
    }
}
