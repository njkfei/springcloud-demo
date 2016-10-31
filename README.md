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
