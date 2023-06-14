package com.zys.springcloud.service.impl;

import com.zys.springcloud.entities.Payment;
import com.zys.springcloud.mapper.PaymentMapper;
import com.zys.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(long id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public int updatePaymentById(Payment payment) {
        return paymentMapper.updatePaymentById(payment);
    }

    @Override
    public int deletePaymentById(long id) {
        return paymentMapper.deletePaymentById(id);
    }
}
