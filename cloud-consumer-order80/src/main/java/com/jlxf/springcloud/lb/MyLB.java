package com.jlxf.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/2 21:22
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }

    private final int getIncrement(){
        int current;
        int next;
        boolean b;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            b = this.atomicInteger.compareAndSet(current, next);
        }while (!b);
        System.out.println("*******第几次访问，次数next: "+next);
        return next;
    }

}
