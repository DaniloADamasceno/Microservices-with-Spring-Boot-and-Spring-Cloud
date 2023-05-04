package com.microservices.hr_oauth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OauthApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println("✅ ✅ ✅ OAUTH is running...✅ ✅ ✅ ");
		System.out.println();
	}
}
