package com.microservices.hrusers.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AppConfiguration {

    @Bean
    public BCryptPasswordEncoder passEncoder() { // --> Para gerar uma senha criptografada
        return new BCryptPasswordEncoder();
    }
}
