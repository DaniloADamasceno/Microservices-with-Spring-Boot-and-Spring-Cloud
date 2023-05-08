package com.microservice.apigateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableResourceServer                       //-> Habilita o servidor de recursos
public class ResourceServeConfiguration extends ResourceServerConfigurerAdapter {

    //?-----------------------------------------  INJECTIONS DEPENDENCY  -----------------------------------------------

    @Autowired
    private JwtTokenStore tokenStore;

    //?----------------------------------------  OBSERVATIONS  ------------------------------------------------------------
    // -> O Resource Server é o servidor que contém os recursos que o cliente deseja acessar.
    private static final String[] PUBLIC = {"/hr-oauth/oauth/token"};
    private static final String[] OPERATOR = {"/hr-worker/**"};
    private static final String[] ADMIN = {"/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**"};


    //?-----------------------------------------------  METHODS  -------------------------------------------------------
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);                                     //-> Define o armazenamento do token
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()                                                                  //-> Define as autorizações
                .antMatchers(PUBLIC).permitAll()                                   //-> Define as autorizações públicas
                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("ADMIN", "OPERATOR", "PERFIL_ADMIN", "PERFIL_OPERATOR")  //-> Define as autorizações de operador
                .antMatchers(ADMIN).hasAnyRole("ADMIN", "PERFIL_ADMIN") //-> Define as autorizações de administrador
                .antMatchers(ADMIN).hasRole("PERFIL_ADMIN")                 //-> Define as autorizações de administrador
                .anyRequest().authenticated();                                       //-> Define que qualquer outra requisição deve ser autenticada

        httpSecurity.cors().configurationSource(corsConfigurationSource());                      //-> Define a configuração de origem
    }


    //?-----------------------------------------------  BEANS  ---------------------------------------------------------
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Arrays.asList("*"));                                      //-> Define as origens permitidas
        corsConfiguration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));  //-> Define os métodos permitidos
        corsConfiguration.setAllowCredentials(true);                                                  //-> Define se permite credenciais
        corsConfiguration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));          //-> Define os cabeçalhos permitidos

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);                             //-> Define a configuração de origem
        return source;
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        FilterRegistrationBean<CorsFilter> filterRegistrationBean //-> Define o filtro de registro
                = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource())); //-> Define o filtro de registro
        filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); //-> Define a ordem de prioridade
        return filterRegistrationBean;

    }

//
//    //------------------------------------------------------------------------------------------------------------------
//    @Autowired
//    private JwtTokenStore tokenStore;
//
//    private static final String[] PUBLIC = { "/hr-oauth/oauth/token" };
//
//    private static final String[] OPERATOR = { "/hr-worker/**" };
//
//    private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };
//
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.tokenStore(tokenStore);
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers(PUBLIC).permitAll()
//                .antMatchers(HttpMethod.GET, OPERATOR).hasAnyRole("OPERATOR", "ADMIN")
//                .antMatchers(ADMIN).hasRole("ADMIN")
//                .anyRequest().authenticated();
//
//        http.cors().configurationSource(corsConfigurationSource());
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.setAllowedOrigins(Arrays.asList("*"));
//        corsConfig.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "PATCH"));
//        corsConfig.setAllowCredentials(true);
//        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//        return source;
//    }
//
//    @Bean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        FilterRegistrationBean<CorsFilter> bean
//                = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
//        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        return bean;
//    }
}

