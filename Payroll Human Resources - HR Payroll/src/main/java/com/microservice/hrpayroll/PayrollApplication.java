package com.microservice.hrpayroll;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker                       // Para habilitar o Hystrix
@EnableEurekaClient                         // Para habilitar o Eureka Client
//@RibbonClient(name = "hr-worker")         // Para habilitar o Ribbon Client (não é mais necessário, pois o Eureka ja tem balanceamento de carga)
@EnableFeignClients                         // Para habilitar o Feign Client
@SpringBootApplication
public class PayrollApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PayrollApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println();
        System.out.println("✅ ✅ ✅ HR PAYROLL is running...✅ ✅ ✅");
        System.out.println();
    }
}
