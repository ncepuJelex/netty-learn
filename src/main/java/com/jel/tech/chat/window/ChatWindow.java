package com.jel.tech.chat.window;

import com.jel.tech.chat.protocol.MsgToAllPacket;
import com.jel.tech.chat.protocol.request.LogoutRequestPacket;
import com.jel.tech.chat.session.Session;
import com.jel.tech.chat.util.SessionUtil;
import io.netty.channel.Channel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * @author jelex.xu
 * @create 2020-01-01 12:32
 **/
public class ChatWindow extends JFrame {

    private static final long serialVersionUID = -6944831795769317874L;

    //聊天历史记录
    private JTextArea historyArea;
    private JScrollPane historyAreaPane;
    //当前输入框
    private JTextArea inputArea;
    //发送按钮
    private JButton sendBtn;
    //右侧好友列表
    private JTable table;

    private Channel channel;

    public ChatWindow() {
        init();
    }

    public ChatWindow(Channel channel) {
        this();
        this.channel = channel;
    }

    private void init() {
        this.setSize(640, 420);
        this.setLocation(200, 200);
        //绝对布局
        this.setLayout(null);

        this.historyArea = new JTextArea();
        historyArea.setEditable(false);// 聊天记录区域不可编辑
        historyAreaPane = new JScrollPane(historyArea);
        historyAreaPane.setBounds(0, 0, 480, 340);
        this.add(historyAreaPane);

        this.inputArea = new JTextArea();
        inputArea.setBounds(0, 350, 430, 50);
        this.add(inputArea);

        this.sendBtn = new JButton("发送");
        sendBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String text = inputArea.getText();

                /**
                 * 改成群聊req packet
                 */
                MsgToAllPacket packet = new MsgToAllPacket();
                Session session = SessionUtil.getSession(channel);
                String name = "";
                if (session != null) {
                    packet.setUserId(session.getUserId());
                    packet.setUserName(name = session.getUserName() + ": ");
                }
                packet.setMessage(name + text);
                channel.writeAndFlush(packet);

                //清空输入框
                inputArea.setText("");
            }
        });
        sendBtn.setBounds(440, 350, 50, 50);
        this.add(sendBtn);

        this.table = new JTable();
        table.setBounds(490, 0, 150, 400);
        this.add(table);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("走之前先关闭channel....");
                LogoutRequestPacket logoutRequestPacket = new LogoutRequestPacket();
                channel.writeAndFlush(logoutRequestPacket);
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ChatWindow();
    }

    /*
     * 刷新界面好友列表:一个n行、1列的列表
     */
    public void refreshContacts(final ArrayList<String> clients) {

        TableModel model = new AbstractTableModel() {
            private static final long serialVersionUID = 1L;

            public int getRowCount() {
                return clients.size(); //一个好友对应一行
            }

            public int getColumnCount() {
                return 1; //只有一列
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                return clients.get(rowIndex);
            }
        };
        table.setModel(model);
    }

    /*
     * 更新聊天记录界面内容
     */
    public void updateHistoryArea(String userName, String line) {
        //老数据
        StringBuilder sb = new StringBuilder(historyArea.getText());
        sb.append("\r\n"); //新的一行显示内容
        sb.append(userName).append(' ').append(line);
        //更新内容
        historyArea.setText(sb.toString());
    }
    /*
     * 更新聊天记录界面，内容中已经包含谁发送的内容，所以不需要userName
     */
    public void refreshChatArea(String content) {
        //老数据
        StringBuilder sb = new StringBuilder(historyArea.getText());
        sb.append("\r\n"); //新的一行显示内容
        sb.append(content);
        //更新内容
        historyArea.setText(sb.toString());
    }

}
