package com.microservices.hrusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableEurekaClient
@SpringBootApplication
public class UserApplication implements CommandLineRunner {

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("✅ ✅ HR USERS is running...✅ ✅");

//--> Para gerar uma senha criptografada
        /*
        Site para gerar a senha criptografada:  -->     https://bcrypt-generator.com/

        System.out.println("BCryptPasswordEncoder: " + passEncoder.encode("123456"));

        */
    }
}
