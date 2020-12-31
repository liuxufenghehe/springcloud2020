package com.jlxf.springcloud.service;

import com.jlxf.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 15:02
 */
public interface PaymentService {

    public int create(Payment payment); //写

    public Payment getPaymentById(Long id);  //读取

}
