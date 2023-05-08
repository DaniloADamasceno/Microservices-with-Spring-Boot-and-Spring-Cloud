package com.microservices.hr_oauth.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@RefreshScope      //-> Atualiza o contexto da aplicação com as novas propriedades
@Configuration
public class AppConfigurationOauth {

    @Value("${jwt.secret}")
    private String jwtSecretKey;
    //?-----------------------------------------------  BEANS  ---------------------------------------------------------
    @Bean
    public BCryptPasswordEncoder passEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
        tokenConverter.setSigningKey(jwtSecretKey);
        return tokenConverter;
    }

    @Bean
    public JwtTokenStore tokenStore() {         //-> Objeto responsável por armazenar o token
        return new JwtTokenStore(accessTokenConverter());
    }

}
