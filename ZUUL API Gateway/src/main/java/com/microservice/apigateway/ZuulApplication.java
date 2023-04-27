package com.microservice.apigateway;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("✅ ✅API Gateway Zuul is running...✅ ✅");
	}
}
