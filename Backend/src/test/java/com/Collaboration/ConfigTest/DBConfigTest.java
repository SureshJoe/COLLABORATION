package com.Collaboration.ConfigTest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfigTest {

	@SuppressWarnings("resource")
	@BeforeClass 
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.Collaboration");
		context.refresh();
	}
	@Test
	public void test() {

	}
	
	
}
