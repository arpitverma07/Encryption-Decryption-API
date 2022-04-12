package com.example.DecryptionApi;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.Repository.RepositoryTrans;
import com.example.Transaction.FeignClientProxy;
import com.example.Transaction.Transaction;


@SpringBootApplication(scanBasePackages={"com.example.*"})
@EnableEurekaClient
@EnableFeignClients(basePackageClasses = FeignClientProxy.class)
@EnableJpaRepositories(basePackageClasses = RepositoryTrans.class)
@EntityScan(basePackageClasses = Transaction.class)
public class DecryptionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecryptionApiApplication.class, args);
	}

}
