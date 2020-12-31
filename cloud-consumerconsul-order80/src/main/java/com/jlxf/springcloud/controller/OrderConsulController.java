package com.jlxf.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/31 21:40
 */
@RestController
public class OrderConsulController {

    private static final String CONSUL_URL= "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consulPayment(){
        return restTemplate.getForObject(CONSUL_URL+"/payment/consul",String.class);
    }

}
