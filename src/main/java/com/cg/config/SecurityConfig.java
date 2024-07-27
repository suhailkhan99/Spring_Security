package com.cg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/*
 * We don’t want to use a username & password provided by Spring. 
 * We will provide our own username & password.So we will customize our Config for security
 */


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	
    	logger.info("Configuring SecurityFilterChain");
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/about").permitAll()
            .anyRequest().authenticated()
        )
        .httpBasic();  // or .formLogin() if you prefer form-based authentication
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
    	logger.info("Creating PasswordEncoder bean");
        return new BCryptPasswordEncoder();
    }
}
