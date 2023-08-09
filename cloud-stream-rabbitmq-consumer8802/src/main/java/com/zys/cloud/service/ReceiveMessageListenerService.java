package com.zys.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ReceiveMessageListenerService {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Consumer<Message<String>> myChannel(){
        return msg -> {
            String serial = msg.getPayload();
            System.out.println(msg);
            System.out.println("消费者1号---------》接受到消息：" + serial + "serverPort:" + serverPort);
        };
    }

}
