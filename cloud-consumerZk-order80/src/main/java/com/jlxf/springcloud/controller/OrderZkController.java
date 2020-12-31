package com.jlxf.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/31 10:03
 */
@RestController
@Slf4j
public class OrderZkController {

    private static final String ORDER_ZK_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentZk(){
        return restTemplate.getForObject(ORDER_ZK_URL +"/payment/zk",String.class);
    }
}
