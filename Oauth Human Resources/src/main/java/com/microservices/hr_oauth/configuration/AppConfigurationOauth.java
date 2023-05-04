package com.microservices.hr_oauth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfigurationOauth {

    //?-----------------------------------------------  BEANS  ---------------------------------------------------------
    @Bean
    public BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter tokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey("mySecretKey");
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore tokenStore() { //-> Objeto responsável por armazenar o token
        return new JwtTokenStore(tokenConverter());
    }

}
