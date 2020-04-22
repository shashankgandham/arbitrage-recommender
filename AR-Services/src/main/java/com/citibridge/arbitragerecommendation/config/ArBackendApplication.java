package com.citibridge.arbitragerecommendation.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={ "com.citibridge.arbitragerecommendation.controller","com.citibridge.arbitragerecommendation.services"})
@EnableJpaRepositories(basePackages = "com.citibridge.arbitragerecommendation.repositories")
@EntityScan(basePackages = "com.citibridge.arbitragerecommendation.login_entities")
public class ArBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArBackendApplication.class, args);
	}
	
}
