package com.shine.video.config.Multipart;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Created by 7le on 2017/5/21 0021.
 */
@Configuration
public class MultipartConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        factory.setMaxFileSize("128MB"); //KB,MB
        // 设置总上传数据总大小
        factory.setMaxRequestSize("10240MB");
        //Sets the directory location where files will be stored.
        //factory.setLocation("/software/video/");
        return factory.createMultipartConfig();
    }
}
