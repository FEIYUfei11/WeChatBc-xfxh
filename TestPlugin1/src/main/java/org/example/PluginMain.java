package org.example;
import com.meteor.wechatbc.entitiy.message.Message;
import com.meteor.wechatbc.event.EventHandler;
import com.meteor.wechatbc.impl.event.Listener;
import com.meteor.wechatbc.impl.event.sub.ReceiveMessageEvent;
import com.meteor.wechatbc.impl.plugin.BasePlugin;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

import java.util.ArrayList;
import java.util.List;

public class PluginMain extends BasePlugin implements Listener {
    @Override
    public void onLoad() {
    }

    // 插件启动时
    @Override
    public void onEnable() {
        BigModelNew receiveMessageListener = new BigModelNew(this);
        getWeChatClient().getEventManager().registerPluginListener(this,receiveMessageListener);
    }

    // 插件卸载时
    @Override
    public void onDisable() {
        getLogger().info("插件卸载啦");
    }







}