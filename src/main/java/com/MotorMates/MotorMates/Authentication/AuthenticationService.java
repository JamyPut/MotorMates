package com.MotorMates.MotorMates.Authentication;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.entity.Role;
import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import com.MotorMates.MotorMates.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final RegisteredUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final RegisteredUserRepository registeredUserRepository;

    @Autowired
    public AuthenticationService(RegisteredUserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager, RegisteredUserRepository registeredUserRepository) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.registeredUserRepository = registeredUserRepository;
    }

    private void RegisterByEmail(RegisterRequest request) {
        Optional<RegisteredUser> userByEmail = registeredUserRepository
                .findByLoginEmail(request.getLoginMail());
        Optional<RegisteredUser> userByLoginName = registeredUserRepository
                .findByLoginName(request.getLoginName());
        if (userByEmail.isPresent()){
            throw new IllegalStateException("User email already exists...");
        }
        else if (userByLoginName.isPresent()){
            throw new IllegalStateException("Username already exists...");
        }
    }

    public AuthenticationResponse registerUser(RegisterRequest request) {
        RegisterByEmail(request);
        var registeredUser = RegisteredUser.builder()
                .loginName(request.getLoginName())
                .loginEmail(request.getLoginMail())
                .loginPassword(passwordEncoder.encode(request.getLoginPassword()))
                .role(Role.RIDER)
                .build();
        repository.save(registeredUser);
        var jwtToken = jwtService.generateToken(registeredUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerOrganizer(RegisterRequest request) {
        RegisterByEmail(request);
        var registeredUser = RegisteredUser.builder()
                .loginName(request.getLoginName())
                .loginEmail(request.getLoginMail())
                .loginPassword(passwordEncoder.encode(request.getLoginPassword()))
                .role(Role.ORGANIZER)
                .build();
        repository.save(registeredUser);
        var jwtToken = jwtService.generateToken(registeredUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        RegisterByEmail(request);
        var registeredUser = RegisteredUser.builder()
                .loginName(request.getLoginName())
                .loginEmail(request.getLoginMail())
                .loginPassword(passwordEncoder.encode(request.getLoginPassword()))
                .role(Role.ADMIN)
                .build();
        repository.save(registeredUser);
        var jwtToken = jwtService.generateToken(registeredUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLoginMail(),
                        request.getPassword()
                )
        );
        var registeredUser = repository.findByLoginEmail(request.getLoginMail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(registeredUser);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
