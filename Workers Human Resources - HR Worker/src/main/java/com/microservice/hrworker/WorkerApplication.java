package com.microservice.hrworker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient                             // Habilita o Eureka Client
@SpringBootApplication
public class WorkerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WorkerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("✅ ✅ ✅ HR WORKER is running...✅ ✅ ✅");
        System.out.println();
    }
}
