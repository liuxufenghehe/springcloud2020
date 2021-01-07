package com.jlxf.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xufeng.liu
 * @email xueshzd@163.com
 * @date 2021/1/7 21:55
 * 路由配置两种方式
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_jlxf",r -> r.path("/guonei").uri("https://news.baidu.com/guonei")).build();
        routes.route("path_route_jlxf2",r -> r.path("/guoji").uri("https://news.baidu.com/guoji")).build();
        routes.route("path_route_jlxf3",r -> r.path("/game").uri("https://news.baidu.com/game")).build();
        return routes.build();
    }


}
