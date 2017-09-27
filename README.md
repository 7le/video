# spring-boot-shine
spring-boot

### application.properties配置

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

具体的文章可以看  [blog任意门](http://7le.top/)
