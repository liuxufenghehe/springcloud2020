package com.jlxf.springcloud.dao;

import com.jlxf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 11:50
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);


}
