# spring-boot-shine

### ❄ blog 

[spring-boot项目笔记：(一)搭建项目](http://7le.top/2017/05/26/springboot%E9%A1%B9%E7%9B%AE%E7%AC%94%E8%AE%B0%EF%BC%9A(%E4%B8%80)%E6%90%AD%E5%BB%BA%E9%A1%B9%E7%9B%AE/)

[spring-boot项目笔记：(二)集成redis，mybatis，swagger](http://7le.top/2017/06/04/springboot%E9%A1%B9%E7%9B%AE%E7%AC%94%E8%AE%B0%EF%BC%9A(%E4%BA%8C)%E9%9B%86%E6%88%90redis%EF%BC%8Cmybatis%EF%BC%8Cswagger/#more)

[spring-boot项目笔记：(三) 事务](http://7le.top/2017/06/11/springboot%E9%A1%B9%E7%9B%AE%E7%AC%94%E8%AE%B0%EF%BC%9A(%E4%B8%89)%20%E4%BA%8B%E5%8A%A1/)

[spring-boot项目笔记：(四) 拦截器和异常处理](http://7le.top/2017/06/13/springboot%E9%A1%B9%E7%9B%AE%E7%AC%94%E8%AE%B0%EF%BC%9A(%E5%9B%9B)%E6%8B%A6%E6%88%AA%E5%99%A8%E5%92%8C%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86/)

[spring-boot项目笔记：(五) 部署和远程调试](http://7le.top/2017/06/19/springboot%E9%A1%B9%E7%9B%AE%E7%AC%94%E8%AE%B0%EF%BC%9A(%E4%BA%94)%20%E9%83%A8%E7%BD%B2%E5%92%8C%E8%BF%9C%E7%A8%8B%E8%B0%83%E8%AF%95/)

[spring-boot项目笔记：(六) 视频截图和转码](http://7le.top/2017/06/21/springboot%E9%A1%B9%E7%9B%AE%E7%AC%94%E8%AE%B0%EF%BC%9A(%E5%85%AD)%20%E8%A7%86%E9%A2%91%E6%88%AA%E5%9B%BE%E5%92%8C%E8%BD%AC%E7%A0%81/)

[spring-cloud项目](https://github.com/7le/springcloud-analysis)

### 🌈 application.properties配置

在resources文件下新建application.properties

```
# 项目contextPath，一般在正式发布版本中，我们不配置
#server.context-path=/video
# 错误页，指定发生错误时，跳转的URL。请查看BasicErrorController源码便知
#server.error.path=/error
# 服务端口
server.port=9000
# session最大超时时间(分钟)，默认为30
server.session-timeout=60
# 该服务绑定IP地址，启动服务器时如本机不是该IP地址则抛出异常启动失败，只有特殊需求的情况下才配置
#server.address=your_IP

#druid
druid.url=jdbc:mysql://your_IP:3306/video_db?useUnicode=true&characterEncoding=utf-8&useSSL=false
druid.driver-class=com.mysql.jdbc.Driver
druid.username=your_username
druid.password=your_password
druid.initial-size=1
druid.min-idle=1
druid.max-active=20
druid.test-on-borrow=true

#mybatis
mybatis.type-aliases-package=com.shine.video.dao
mybatis.mapper-locations=classpath:mapping/*.xml

#redis
spring.redis.host=your_IP
spring.redis.password=your_password
spring.redis.port=16379
spring.redis.pool.max-idle=100
spring.redis.pool.min-idle=1
spring.redis.pool.max-active=1000
spring.redis.pool.max-wait=-1

#log
logging.config=classpath:logback.xml
logging.path=/software/boot-log
```
