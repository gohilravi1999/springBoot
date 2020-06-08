package com.bestPracticesForApi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bestPracticesForApi.controller")
public class BestPracticesForApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestPracticesForApiApplication.class, args);
	}

}
