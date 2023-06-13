package com.zys.springcloud.service;

import com.zys.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {

    //创建一个payment
    public int create(Payment payment);

    //通过Id获取payment
    public Payment getPaymentById(long id);

    //根据id修改一个payment
    public int updatePaymentById(Payment payment);

    //根据id删除payment
    public int deletePaymentById(long id);

}
