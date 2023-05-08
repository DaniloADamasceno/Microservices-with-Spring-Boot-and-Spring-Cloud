package com.microservice.hreurekaserver;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer 									// habilitar o Eureka Server
@SpringBootApplication
public class EurekaServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println("✅ ✅ ✅ HR Eureka Server is running...✅ ✅ ✅");
		System.out.println();
	}
}
