package com.zys.springcloud.controller;

import com.zys.springcloud.entities.CommonResult;
import com.zys.springcloud.entities.Payment;
import com.zys.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/lb/")
    public String port(){
        return serverPort;
    }

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){

        log.info("/payment/create创建========");
        int result = paymentService.create(payment);
        if (result > 0) return new CommonResult(200,"创建成功！serverPort=" + serverPort,result);
        else return new CommonResult(444,"创建失败！",null);

    }

    @GetMapping("payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
        log.info("payment/get/{id}获取" + id + "中========");
        Payment result = paymentService.getPaymentById(id);
        if (result != null) return new CommonResult(200,"获取成功！serverPort=" + serverPort,result);
        else return new CommonResult(444,"获取失败！",null);

    }

}
