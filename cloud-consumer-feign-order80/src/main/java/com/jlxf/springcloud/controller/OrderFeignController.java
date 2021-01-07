package com.jlxf.springcloud.controller;

import com.jlxf.springcloud.entities.CommonResult;
import com.jlxf.springcloud.entities.Payment;
import com.jlxf.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/3 21:30
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id){
        return paymentFeignService.get(id);
    }

    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }

}
