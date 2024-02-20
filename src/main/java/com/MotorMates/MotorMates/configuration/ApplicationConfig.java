package com.MotorMates.MotorMates.configuration;

import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final RegisteredUserRepository repository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> repository.findByLoginEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
