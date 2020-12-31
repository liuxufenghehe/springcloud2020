package com.jlxf.springcloud.service.impl;

import com.jlxf.springcloud.dao.PaymentDao;
import com.jlxf.springcloud.entities.Payment;
import com.jlxf.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 15:02
 */
@Service
public class PaymentServiceImpl implements PaymentService{


    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
