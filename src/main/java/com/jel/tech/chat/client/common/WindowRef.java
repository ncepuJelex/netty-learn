package com.jel.tech.chat.client.common;

import com.jel.tech.chat.window.ChatWindow;

/**
 * @author jelex.xu
 * @create 2020-01-01 16:59
 **/
public class WindowRef {

    private static WindowRef ref0;

    private static ChatWindow window;

    private static boolean visible = false;


    public WindowRef(ChatWindow window) {
        this.window = window;
    }

    // invoke after set(...)
    public static ChatWindow get() {
        if (ref0 == null) {
            return null;
        }
        return ref0.window;
    }

    public static void set(WindowRef ref) {

        if (ref != null && ref0 == null) {
            ref0 = ref;
        }
    }

    public static void setVisible(boolean visible) {
        WindowRef.visible = visible;
        get().setVisible(visible);
    }

    public static boolean isVisible() {
        return visible;
    }

}
