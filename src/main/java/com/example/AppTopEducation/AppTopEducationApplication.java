package com.example.AppTopEducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.AppTopEducation.controllers, com.example.AppTopEducation.entities, com.example.AppTopEducation.repositories, com.example.AppTopEducation.services")
public class AppTopEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppTopEducationApplication.class, args);
	}

}
