# spring-boot-shine
spring-boot

> spring-boot 热部署
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>springloaded</artifactId>
        <version>1.2.5.RELEASE</version>
    </dependency>
</dependencies>
```
```
  添加以后，通过mvn spring-boot:run启动就支持热部署了。
　注意：使用热部署的时候，需要IDE编译类后才能生效，你可以打开自动编译功能，这样在你保存修改的时候，类就自动重新加载了。
　通过在IDEA下面的终端中运行mvn spring-boot:run命令
 ```
