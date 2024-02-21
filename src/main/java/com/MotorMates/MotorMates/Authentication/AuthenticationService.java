package com.MotorMates.MotorMates.Authentication;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.entity.Role;
import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import com.MotorMates.MotorMates.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final RegisteredUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
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
