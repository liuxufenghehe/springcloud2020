package com.jlxf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/2 21:18
 */
public interface LoadBalancer {

    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
