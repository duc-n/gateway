package com.coface.corp.autonomy.programservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    //@Autowired
    public void registerAuthProvider(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.NEVER))
                //Set permissions on endpoints
                .authorizeHttpRequests(auth -> auth
                        //public endpoints
                       // .requestMatchers(HttpMethod.GET, "api/program").permitAll()
                        //.requestMatchers(HttpMethod.POST, "/api/auth/login/**").permitAll()
                        //private endpoints
                        .anyRequest().authenticated())
                .httpBasic(httpBasicSpec -> httpBasicSpec.disable())
                .formLogin(formLoginSpec -> formLoginSpec.disable())
                .build();

    }
}
