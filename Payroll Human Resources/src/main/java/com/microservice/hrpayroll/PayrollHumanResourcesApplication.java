package com.microservice.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PayrollHumanResourcesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollHumanResourcesApplication.class, args);
	}

}
