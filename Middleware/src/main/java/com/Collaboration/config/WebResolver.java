package com.Collaboration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.Collaboration")

public class WebResolver {
	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
		System.out.println("---view Resover Bean Creation---");
		InternalResourceViewResolver iResolver=new InternalResourceViewResolver();
		iResolver.setPrefix("/WEB-INF/jsp");
		iResolver.setSuffix(".jsp");
		return iResolver;
	}

}
