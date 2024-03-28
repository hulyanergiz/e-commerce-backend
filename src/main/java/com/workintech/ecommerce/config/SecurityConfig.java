package com.workintech.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SecurityConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(UserDetailsService userDetailsService){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }
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
            auth.requestMatchers(HttpMethod.GET, "/roles/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/roles/**").permitAll();
            auth.requestMatchers(HttpMethod.PUT, "/roles/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/roles/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/users/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/users/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/store/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/store/**").hasAuthority("ADMIN");
            auth.requestMatchers(HttpMethod.PUT, "/store/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/store/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/cart-items/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/cart-items/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/cart-items/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/address/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/address/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/address/**").permitAll();
            auth.requestMatchers(HttpMethod.GET, "/card/**").permitAll();
            auth.requestMatchers(HttpMethod.POST, "/card/**").permitAll();
            auth.requestMatchers(HttpMethod.DELETE, "/card/**").permitAll();


            auth.requestMatchers("/signup/**").permitAll();
            auth.anyRequest().authenticated();

        }).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults()).build();
    }

}
