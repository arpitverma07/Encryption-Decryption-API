package com.example.EncryptionApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages={"com.example"})
@EnableEurekaClient
public class EncryptionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncryptionApiApplication.class, args);
	}

}
