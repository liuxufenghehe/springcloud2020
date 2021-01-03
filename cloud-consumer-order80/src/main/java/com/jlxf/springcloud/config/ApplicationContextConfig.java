package com.jlxf.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2020/12/29 17:23
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced      //实现负载均衡
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
