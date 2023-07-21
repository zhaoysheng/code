package com.zys.springcloud.service.impl;

import com.zys.springcloud.service.FeignService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class FallbackFeignServiceImpl implements FeignService {
    @Override
    public String payment_Info_Ok(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String payment_Info_timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
