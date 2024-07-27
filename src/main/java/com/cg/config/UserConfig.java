package com.cg.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(UserConfig.class);
	
	private final PasswordEncoder passwordEncoder;
	
	public UserConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        
    }
	
	 @Bean
	 public UserDetailsService userDetailsService() {
		 logger.info("enter in userdetails");
		 return new InMemoryUserDetailsManager(
		            User.withUsername("customUser")
		                .password(passwordEncoder.encode("customPass")) // Encode the password
		                .roles("USER")
		                .build()
		        );
	    }

}
