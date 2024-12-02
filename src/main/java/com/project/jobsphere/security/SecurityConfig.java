package com.project.jobsphere.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())// Disable CSRF for testing; enable it in production
                .cors(cors -> cors.and())
                .authorizeRequests(requests -> requests
                        .requestMatchers("/api/employee/register", "/api/employer/register").permitAll() // Public endpoints
                        .requestMatchers(HttpMethod.GET,"/api/job/all").permitAll()
                        .requestMatchers("/api/employee/**").hasRole("EMPLOYEE") // Employee access
                        .requestMatchers("/api/employer/**").hasRole("EMPLOYER") // Employer access
                        .requestMatchers("/api/job/**","/api/application/**","/api/application/job/**").authenticated()
                        .anyRequest().permitAll())
                        .httpBasic(withDefaults()); // Enable Basic Authentication
        return http.build();
    }
  
    
    public AuthenticationManagerBuilder authManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return auth;
    }
}
