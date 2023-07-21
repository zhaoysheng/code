package com.zys.springcloud.service;

import com.zys.springcloud.service.impl.FallbackFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
// FeignFallback 客户端的服务降级 针对 CLOUD-PROVIDER-HYSTRIX-PAYMENT 该服务 提供了一个 对应的服务降级类
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = FallbackFeignServiceImpl.class)
//fallback = FallbackFeignServiceImpl.class用于配置CLOUD-PROVIDER-HYSTRIX-PAYMENT服务器宕机后无法连接的异常
public interface FeignService {

    @GetMapping("/payment/hytrix/ok/{id}")
    public String payment_Info_Ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hytrix/timeout/{id}")
    public String payment_Info_timeout(@PathVariable("id") Integer id);

}
