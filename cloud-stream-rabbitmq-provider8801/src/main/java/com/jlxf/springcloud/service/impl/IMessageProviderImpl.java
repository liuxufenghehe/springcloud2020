package com.jlxf.springcloud.service.impl;

import cn.hutool.core.lang.UUID;
import com.jlxf.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/15 17:50
 */
@EnableBinding(Source.class)  //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider{

    @Resource
    private MessageChannel output; //消息的发送管道

    @Override
    public String send() {
        String message = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(message).build());
        System.out.println("************message:"+message);
        return message;
    }
}
