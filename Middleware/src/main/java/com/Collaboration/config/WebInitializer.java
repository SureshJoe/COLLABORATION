package com.Collaboration.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.Collaboration.Configure.DBConfig;



public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	
@Override
protected Class<?>[] getRootConfigClasses()
{
	System.out.println("---getRootConfigClasses() method---");
	return new Class[] {WebResolver.class,DBConfig.class};
	}
@Override
protected Class<?>[] getServletConfigClasses()
{
	System.out.println("---getServletConfigClasses---");
	return null;
	}
@Override
protected String[] getServletMappings()
{
	System.out.println("---getServletMappings---");
	return new String[] {"/"};
	}
}
