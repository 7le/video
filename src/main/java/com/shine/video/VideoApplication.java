package com.shine.video;

import com.shine.video.interceptor.LoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableTransactionManagement
@SpringBootApplication
public class VideoApplication implements TransactionManagementConfigurer {


	@Resource(name="txManager1")
	private PlatformTransactionManager txManager1;

	// 创建事务管理器1
	@Bean(name = "txManager1")
	public PlatformTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return txManager1;
	}

	@Configuration
	static class WebMvcConfigurer extends WebMvcConfigurerAdapter {

		@Bean
		LoginInterceptor loginInterceptor() {
			return new LoginInterceptor();
		}

		public void addInterceptors(InterceptorRegistry registry) {
			registry.addInterceptor(loginInterceptor()).addPathPatterns("/user/**","/collect/**","/register","/video/**")
					.excludePathPatterns("/video/show/**","/video");
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

}
