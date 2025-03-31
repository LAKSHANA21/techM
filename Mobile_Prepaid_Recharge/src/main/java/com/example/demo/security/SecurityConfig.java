package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        http.csrf().disable() // Disable CSRF protection
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers("/api/userlogin/**").permitAll()// Allow OPTIONS requests
                .requestMatchers("/api/userlogin/validate-credentials").permitAll()
                .requestMatchers("/api/userlogin/admin-login").permitAll()
                .requestMatchers("/api/userlogin/refresh-token").permitAll()
                .requestMatchers("/auth/validate").permitAll()
                .requestMatchers("/api/rechargeplans/**").permitAll()
                .requestMatchers("/api/rechargehistory/**").permitAll()
                .requestMatchers("/api/payments/**").permitAll()
                .requestMatchers("/api/users/**").permitAll()
                .requestMatchers("/api/send-email/**").permitAll()
                .requestMatchers("/api/send-otp").permitAll()
                .requestMatchers("/api/userlogin/validate-otp").permitAll() // Ensure this endpoint is permitted
                .requestMatchers("/api/validate-token").authenticated()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}