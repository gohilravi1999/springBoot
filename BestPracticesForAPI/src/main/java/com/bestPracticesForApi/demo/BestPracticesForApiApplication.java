package com.bestPracticesForApi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.bestPracticesForApi.controller,com.bestPracticesForApi.services"})
@EntityScan("com.bestPracticesForApi.model")
@EnableJpaRepositories("com.bestPracticesForApi.repository")
public class BestPracticesForApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestPracticesForApiApplication.class, args);
	}

}
