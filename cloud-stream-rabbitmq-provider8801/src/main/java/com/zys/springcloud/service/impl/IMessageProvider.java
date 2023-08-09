package com.zys.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class IMessageProvider implements com.zys.springcloud.service.IMessageProvider {

    @Autowired
    StreamBridge streamBridge;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        streamBridge.send("myChannel-out-0",serial);
        System.out.println("****serial:" + serial);
        return null;
    }
}
