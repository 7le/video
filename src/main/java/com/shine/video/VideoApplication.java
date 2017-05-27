package com.shine.video;

import com.shine.video.interceptor.LoginInterceptor;
import com.shine.video.interceptor.PerformanceInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
public class VideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
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
}
