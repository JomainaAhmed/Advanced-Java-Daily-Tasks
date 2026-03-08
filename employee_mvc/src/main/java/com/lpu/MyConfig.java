package com.lpu;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lpu") //subpackages come under com.lpu which is the main package

public class MyConfig {
	
	@Bean
	public ViewResolver viewResolver() {
	
	
	InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	resolver.setPrefix("/WEB-INF/view/");//page folder structure
	resolver.setSuffix(".jsp");//extension
	return resolver;
		//WEB-INF/view/home.jsp
	}
	
}
