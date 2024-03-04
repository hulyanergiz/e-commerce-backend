package com.workintech.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf((csrf) -> csrf.disable()).authorizeHttpRequests(auth -> {

            //TODO: Authorizations should be added
            auth.requestMatchers(HttpMethod.GET, "/categories/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/categories/**").permitAll();
            auth.requestMatchers(HttpMethod.PUT, "/categories/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/categories/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/products/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/products/**").permitAll();
            auth.requestMatchers(HttpMethod.PUT,"/products/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE,"/products/**").permitAll();
            auth.anyRequest().authenticated();

        }).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();
    }

}
