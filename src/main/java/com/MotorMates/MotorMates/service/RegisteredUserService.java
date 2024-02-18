package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "User with email %s not found";
    private final RegisteredUserRepository registeredUserRepository;

    public RegisteredUserService(RegisteredUserRepository registeredUserRepository) {
        this.registeredUserRepository = registeredUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return registeredUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }
}
