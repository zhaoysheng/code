package com.zys.springcloud.controller;

import com.zys.springcloud.service.impl.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMessageController {

    @Autowired
    IMessageProvider iMessageProvider;

    @GetMapping("/provider/send")
    public String sendMessage(){
        iMessageProvider.send();
        return "aaaa";
    }

}
