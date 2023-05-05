package com.microservice.apigateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer                       //-> Habilita o servidor de recursos
public class ResourceServeConfiguration extends ResourceServerConfigurerAdapter {

    //?----------------------------------------  OBSERVATIONS  ------------------------------------------------------------
    // -> O Resource Server é o servidor que contém os recursos que o cliente deseja acessar.


    private static final String[] PUBLIC = {"/hr-oauth/oauth/token"};
    private static final String[] OPERATOR = {"/hr-worker/**"};
    private static final String[] ADMIN = {"/hr-payroll/**", "/hr-user/**" }; //, "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**"};
    //?-----------------------------------------  INJECTIONS DEPENDENCY  -----------------------------------------------
    @Autowired
    private JwtTokenStore tokenStore;


    //?-----------------------------------------------  METHODS  -------------------------------------------------------
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);                                     //-> Define o armazenamento do token
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()                                                                  //-> Define as autorizações
                .antMatchers(PUBLIC).permitAll()                                   //-> Define as autorizações públicas
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")  //-> Define as autorizações de operador
                .antMatchers(ADMIN).hasRole("ADMIN")                        //-> Define as autorizações de administrador
                .anyRequest().authenticated();                                       //-> Define que qualquer outra requisição deve ser autenticada
    }
}