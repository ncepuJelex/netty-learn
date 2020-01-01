package com.jel.tech;

import com.jel.tech.chat.window.ChatWindow;
import org.junit.Test;

/**
 * @author jelex.xu
 * @create 2020-01-01 13:02
 **/
public class ChatWindowTest {

    /**
     * 窗口会一闪而过，证明 此 测试线程 和 窗口那个 不是同一个
     *
     * 要想看到窗口，运行 ChatWindow 中的main()
     */
    @Test
    public void fun() {

        new ChatWindow();
    }
}
