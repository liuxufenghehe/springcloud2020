package com.jlxf.springcloud.controller;

import com.jlxf.springcloud.entities.CommonResult;
import com.jlxf.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 15:20
 */
@RestController
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL +"/payment/create",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable Long id){
        return restTemplate.getForObject(PAYMENT_URL +"/payment/get/"+id,CommonResult.class);
    }


}
