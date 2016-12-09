# springcloud-demo
springcloud demo。包括如下组件：
* spring cloud config : 作为配置中心
* eureka server: 作为服务注册中心
* eureka client : 服务注册中心的客户端
* admin: 监控控制台，是web ui界面
* hystrix dashboard: 
* user-service: 运行一个服务demo
* service-client: 调用user service的服务，使用RestTemplate通过服务注册中心获取服务提供者地址
* feign-client: 通过@Feign远程调用服务
* spring cloud zipkin server: 作为tracing系统

## 说明
* 配置中心的配置文件，保存在另外一个git仓库中,地址是!(https://github.com/njkfei/springcloud-config-repo)[https://github.com/njkfei/springcloud-config-repo]
* 本demo运行成功
* 本demo运行成功，还是挺麻烦的，需要一点运气
* 没有父POM.xml，个人不太喜欢这种父POM.XML的方式
* hystrixdashboard启动成功，但没有做功能性测试

## 启动方法
进入每个工程，有两种方式
### mvn spring-boot:run
在pom.xml目前下，运行下面的命令即可。
```
mvn spring-boot:run
```
### java -jar xxx.jar
在pom.xml目录下，生成jar包
```
mvn clean install -Dmaven.test.skip=true
cd target
java -jar xxx.jar
```

```
cd configuration-service
mvn clean install -Dmaven.test.skip=true

cd ../eureka-service
mvn clean install -Dmaven.test.skip=true

cd ../admin
mvn clean install -Dmaven.test.skip=true

cd ../hystrixdashboard
mvn clean install -Dmaven.test.skip=true

cd ../zipkinservice
mvn clean install -Dmaven.test.skip=true

cd ../userservice
mvn clean install -Dmaven.test.skip=true

cd ../feignclient
mvn clean install -Dmaven.test.skip=true

cd ../serviceclient
mvn clean install -Dmaven.test.skip=true

cd ../zuulapigateway
mvn clean install -Dmaven.test.skip=true
```

## 启动顺序
1. configuration-service
1. eureka-service
1. admin
1. hystrixdashboard
1. zipkinservice
1. userservice
1. feignclient
1. serviceclient
1. zuulapigateway

```
cd configuration-service
mvn spring-boot:run &

cd ../eureka-service
mvn spring-boot:run &

cd ../admin
mvn spring-boot:run &

cd ../hystrixdashboard
mvn spring-boot:run &

cd ../zipkinservice
mvn spring-boot:run &

cd ../userservice
mvn spring-boot:run &

cd ../feignclient
mvn spring-boot:run &

cd ../serviceclient
mvn spring-boot:run &

cd ../zuulapigateway
mvn spring-boot:run &
```

## 坑
### @Feign报错
错误如下：
```
class not found : Feign.LOG
```
原因：

resttemplate和@Feign不能共存，因为这个问题，导致浪费2小时

### user-service无法注册到zipkin server
#### 现象
在zipkin server的web ui中，看不到user-service，导致2小时没有，看代码，分析原因，眼睛疼死了。

#### 原因
神器idea mvn install不行，需要手工 mvn reimport一下。通过maven插件可以看zipkin的依赖是否加载成功。
成功的话，就可以在web-ui中看到user-service.

## 待做
* zipkin目前是把数据放在mem当中，需要调研rabbit mq存储数据。
* spring cloud stream也要研究一下
* 性能测试需要关注
* admin 增加邮件支持
* admin 监控增加ssl支持
* zuul API 网关，作安全攻防用，参数修改使用
* 日志系统集成
* mysql 日志监控：mybatis + logback
