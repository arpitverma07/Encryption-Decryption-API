package com.example.DecryptionApi;

import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages={"com.example"})
@EnableEurekaClient
@EnableFeignClients
public class DecryptionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecryptionApiApplication.class, args);
	}

}
