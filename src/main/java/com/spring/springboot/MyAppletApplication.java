package com.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.spring.springboot.dao"})
public class MyAppletApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppletApplication.class, args);
	}
}
