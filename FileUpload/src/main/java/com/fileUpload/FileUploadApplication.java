package com.fileUpload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fileUpload.controller"})
@EnableJpaRepositories("com.fileUpload.repository")
public class FileUploadApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FileUploadApplication.class, args);
	}

}
