package com.jlxf.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/3 21:13
 */
@EnableFeignClients
@SpringBootApplication
public class ConsumerFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeignMain80.class,args);
    }

}
