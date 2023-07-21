package com.zys.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zys.springcloud.service.FeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
//@HystrixCommand、@DefaultProperties处理运行时异常和超时异常
@DefaultProperties(defaultFallback = "payment_global_fallback_method")
//不写@HystrixProperty中的超时时间openfeign默认超时时间1秒
//,commandProperties = {
//        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//}
public class ConsumerPaymentController {

    @Autowired
    FeignService feignService;

    @GetMapping("consumer/payment/hytrix/ok/{id}")
    public String payment_Info_Ok(@PathVariable("id") Integer id){
        String result = feignService.payment_Info_Ok(id);
        return result;
    }

    @GetMapping("consumer/payment/hytrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "payment_Info_timeout_handler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
    @HystrixCommand
    public String payment_Info_timeout(@PathVariable("id") Integer id){
        String result = feignService.payment_Info_timeout(id);
        return result;
    }
    public String payment_Info_timeout_handler(@PathVariable("id") Integer id){
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
    public String payment_global_fallback_method(){
        return "global--全局服务降级o(╥﹏╥)o";
    }


}
