package com.jlxf.springcloud.controller;

import com.jlxf.springcloud.entities.CommonResult;
import com.jlxf.springcloud.entities.Payment;
import com.jlxf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 15:20
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("结果"+ result);
        if(result > 0){
            return new CommonResult(200,"数据插入成功！端口："+serverPort,result);
        }else{
            return new CommonResult(444,"数据插入失败！端口："+serverPort,null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult get(@PathVariable Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("结果"+ result);
        if(result != null){
            return new CommonResult(200,"数据查询成功！端口："+serverPort,result);
        }else{
            return new CommonResult(444,"数据查询失败！端口："+serverPort,null);
        }
    }



}
