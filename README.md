# springcloud2020
springcloud各组件的理论实践

关于eureka,zookeeper,consul注册中心的CAP原理：
C:强一致性(Consistency)
A:高可用(Availability)
P:分区容错性(Partition tolerance)
Eureka(AP),zookeeper/consul(CP)

alibaba组件docker部署流程：
（本人为虚拟机）
docker容器默认启动使用bridge桥接网络（默认网段:172.17.0.0），可自行创建network指定ip
需要验证指定ip启动容器（以nginx为例）
1、验证 docker -p 80:80 宿主机可访问到容器服务
2、验证 docker -p 8080:80 宿主机和容器独立访问  http://hadoop102:8080,http://172.17.0.4
3、验证 创建自定义网络，指定ip
（1）创建自定义网段：172.15.1.0
docker network create --driver bridge --subnet=172.15.1.0/16  cloud-net
（2）容器启动指定ip和端口：
docker run -itd --name cloud-nginx --net cloud-net --ip 172.15.1.3 -p 8080:80 nginx:1.10
（3）windows cmd 添加路由：
route add 172.15.1.0 mask 255.255.255.0 192.168.1.102
（4）浏览器访问：1）宿主机：http://hadoop102:8080 ；2）http://http://172.15.1.3/ ；

docker nacos集群创建：
集群节点（1）
docker run -d --name cloud-nacos-01 --net cloud-net --ip 172.15.1.4 --hostname cloud-nacos-01 --restart always \
-e MYSQL_SERVICE_HOST=172.15.1.2 \
-e MYSQL_SERVICE_PORT=3306 \
-e MYSQL_SERVICE_DB_NAME=nacos_config \
-e MYSQL_SERVICE_USER=root \
-e MYSQL_SERVICE_PASSWORD=root \
-e SPRING_DATASOURCE_PLATFORM=mysql \
-e MYSQL_DATABASE_NUM=1 \
-e NACOS_USER=nacos \
-e NACOS_PASSWORD=nacos \
-e NACOS_APPLICATION_PORT=3333 \
-e MODE=cluster \
-e NACOS_SERVERS=172.15.1.4:3333,172.15.1.5:4444,172.15.1.6:5555 \
-e JVM_XMS=512m \
-e JVM_XMX=512m \
-e JVM_XMN=256m \
-e JVM_MS=32m \
-e JVM_MMS=80m \
-p 3333:3333 nacos/nacos-server:1.2.1

集群节点（2）、（3）同上，修改局部参数即可！
访问：http://172.15.1.3/nacos/index.html
用户名/密码：nacos/nacos,登录即可查看到所有节点信息
