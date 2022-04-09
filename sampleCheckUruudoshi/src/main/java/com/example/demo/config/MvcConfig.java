package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * 「/login」というURLからlogin.htmlを呼び出す
	 */
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("now");
        registry.addViewController("/").setViewName("now");
        registry.addViewController("/list").setViewName("list");
        registry.addViewController("/check").setViewName("check");
        registry.addViewController("/result").setViewName("result");
        registry.addViewController("/login").setViewName("login");
	}

}
