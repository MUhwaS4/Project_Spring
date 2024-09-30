package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjectTestPjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTestPjApplication.class, args);
	}

}
