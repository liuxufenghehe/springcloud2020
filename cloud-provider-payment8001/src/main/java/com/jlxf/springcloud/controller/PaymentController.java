package com.jlxf.springcloud.controller;

import com.jlxf.springcloud.entities.CommonResult;
import com.jlxf.springcloud.entities.Payment;
import com.jlxf.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private DiscoveryClient discoveryClient;


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

    @GetMapping("/payment/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service--"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance: instances) {
            log.info("instance---"+instance.getHost()+"---"+instance.getPort()+"---"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLb(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

}
