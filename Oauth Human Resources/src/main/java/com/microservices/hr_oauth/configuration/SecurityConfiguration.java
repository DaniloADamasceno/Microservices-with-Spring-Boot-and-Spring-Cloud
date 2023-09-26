package com.microservices.hr_oauth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    //?-----------------------------------------------  INJECT DEPENDENCIES -------------------------------------------
    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Autowired
    private UserDetailsService userDetailsService;


    //?-----------------------------------------------  METHODS  -------------------------------------------------------
    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passEncoder);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //-------------->>  Métodos liberados para todos os usuarios com perfil de PUBLIC <<--------------------
                .antMatchers(HttpMethod.GET, "/hr-oauth/oauth/token").hasRole("PUBLIC")

                //-------------->>  Métodos liberados para TODOS os Perfis  <<------------------------------------------
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .antMatchers(HttpMethod.GET, "/users/search").permitAll()
                .antMatchers(HttpMethod.GET, "hr-oauth/users/search").permitAll()
                .antMatchers(HttpMethod.GET, "/hr-oauth/**").permitAll()
                .antMatchers(HttpMethod.POST, "/hr-oauth/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/hr-oauth/**").permitAll()

                //-------------->  Métodos liberados para os usuarios com perfil de OPERATOR e PERFIL_OPERATOR  <<------
                .antMatchers(HttpMethod.GET, "/hr-worker/**").hasAnyRole("OPERATOR", "PERFIL_OPERATOR")
                .antMatchers(HttpMethod.PUT, "/hr-worker/**").hasAnyRole("OPERATOR", "PERFIL_OPERATOR")
                .antMatchers(HttpMethod.POST, "/hr-worker/**").hasAnyRole("OPERATOR", "PERFIL_OPERATOR")

                //-------------->  Métodos liberados para os usuarios com perfil de ADMIN e PERFIL_ADMIN  <<------------
//                POST
                .antMatchers(HttpMethod.POST, "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**",
                        "/hr-oauth/actuator/**","/hr-worker/**").hasAnyRole("ADMIN", "PERFIL_ADMIN")
//                PUT
                .antMatchers(HttpMethod.PUT, "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**",
                        "/hr-oauth/actuator/**","/hr-worker/**").hasAnyRole("ADMIN", "PERFIL_ADMIN")
//                DELETE
                .antMatchers(HttpMethod.DELETE, "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**",
                        "/hr-oauth/actuator/**","/hr-worker/**").hasAnyRole("ADMIN", "PERFIL_ADMIN")
//                GET
                .antMatchers(HttpMethod.GET, "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**",
                        "/hr-oauth/actuator/**","/hr-worker/**").hasAnyRole("ADMIN", "PERFIL_ADMIN")
                .anyRequest().authenticated();
    }
}