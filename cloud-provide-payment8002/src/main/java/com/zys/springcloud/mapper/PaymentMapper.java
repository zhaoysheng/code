package com.zys.springcloud.mapper;

import com.zys.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaymentMapper {

    //创建一个payment
    public int create(Payment payment);

    //通过Id获取payment
    public Payment getPaymentById(@Param("id") long id);

    //根据id修改一个payment
    public int updatePaymentById(Payment payment);

    //根据id删除payment
    public int deletePaymentById(@Param("id") long id);

}
