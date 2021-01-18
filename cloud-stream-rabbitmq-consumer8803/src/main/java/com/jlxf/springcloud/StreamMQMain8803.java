package com.jlxf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/18 11:07
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8803.class,args);
    }

}
