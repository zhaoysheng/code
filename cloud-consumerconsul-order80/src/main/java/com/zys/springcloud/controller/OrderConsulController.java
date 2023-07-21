package com.zys.springcloud.controller;

import com.zys.springcloud.entities.CommonResult;
import com.zys.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderConsulController {

    private static final String PAYMENT_URL = "http://consul-provider-payment";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String create(){

        log.info("/consumer/create访问中==========");
        String commonResult = restTemplate
                .getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return commonResult;

    }


}
