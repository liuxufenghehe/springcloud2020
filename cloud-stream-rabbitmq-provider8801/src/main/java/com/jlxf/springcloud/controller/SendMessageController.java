package com.jlxf.springcloud.controller;

import com.jlxf.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/15 17:59
 */
@RestController
@Slf4j
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        String message = messageProvider.send();
        log.info("发送消息："+message);
        return message;
    }

}
