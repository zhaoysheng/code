package com.zys.springcloud.controller;

import com.zys.springcloud.entities.CommonResult;
import com.zys.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer/create")
    public CommonResult<Payment> create(Payment payment){

        log.info("/consumer/create访问中==========");
        CommonResult commonResult = restTemplate
                .postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
        return commonResult;

    }

    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id){

        log.info("/consumer/get/{id}访问中==========");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);

    }

}
