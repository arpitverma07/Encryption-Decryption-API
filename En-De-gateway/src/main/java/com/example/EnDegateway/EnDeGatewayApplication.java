package com.example.EnDegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EnDeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnDeGatewayApplication.class, args);
	}

}
