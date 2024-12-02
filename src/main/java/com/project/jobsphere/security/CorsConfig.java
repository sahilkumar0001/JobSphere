package com.project.jobsphere.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*"); // Allow all origins. Replace with specific origins in production
        config.addAllowedMethod("*");       // Allow all HTTP methods (GET, POST, OPTIONS, etc.)
        config.addAllowedHeader("*");       // Allow all headers
        config.setAllowCredentials(true);   // Allow cookies/auth credentials

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply to all endpoints
        return new CorsFilter(source);
    }
}
