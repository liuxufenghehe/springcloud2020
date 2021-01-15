package com.jlxf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/15 10:39
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3366 {

    public static void main(String[] args) {
        SpringApplication.run( ConfigClientMain3366.class,args);
    }

}
