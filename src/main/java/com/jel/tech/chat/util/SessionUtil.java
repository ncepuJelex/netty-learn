package com.jel.tech.chat.util;

import com.jel.tech.chat.protocol.response.RefreshContactsResponsePacket;
import com.jel.tech.chat.session.Attributes;
import com.jel.tech.chat.session.Session;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {

    private static final Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();

    private static final Map<String, ChannelGroup> groupIdChannelGroupMap = new ConcurrentHashMap<>();

    private static final ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static void unBindSession(Channel channel) {
        if (hasLogin(channel)) {
            Session session = getSession(channel);
            userIdChannelMap.remove(session.getUserId());
            channel.attr(Attributes.SESSION).set(null);
            System.out.println(session + " 退出登录!");
        }
    }

    public static boolean hasLogin(Channel channel) {

        return getSession(channel) != null;
    }

    public static Session getSession(Channel channel) {

        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String userId) {

        return userIdChannelMap.get(userId);
    }

    public static void bindChannelGroup(String groupId, ChannelGroup channelGroup) {
        groupIdChannelGroupMap.put(groupId, channelGroup);
    }

    public static ChannelGroup getChannelGroup(String groupId) {
        return groupIdChannelGroupMap.get(groupId);
    }

    public static void addChannel(Channel channel) {
        channels.add(channel);
    }

    public static ChannelGroup getChannels() {
         return channels;
    }

    public static void removeChannel(Channel channel) {

        channels.remove(channel);
    }

    /**
     * 刷新好友列表
     */
    public static void allRefreshContacts() {

        // 刷新好友列表 事件，应该单独维护好友列表
        ArrayList<String> contacts = new ArrayList<>(channels.size());
        for (Channel c : channels) {
            Session session = SessionUtil.getSession(c);
            contacts.add(session.getUserName());
        }
        RefreshContactsResponsePacket contactsResponsePacket = new RefreshContactsResponsePacket();
        contactsResponsePacket.setContacts(contacts);
        channels.writeAndFlush(contactsResponsePacket);
    }
}
