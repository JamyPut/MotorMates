package com.MotorMates.MotorMates.Authentication;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum/auth")
@RequiredArgsConstructor
 class AuthenticationController {

   private final AuthenticationService service;
   private final RegisteredUserRepository repository;

   @PostMapping("/registerUser")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest request
    ){
      return ResponseEntity.ok(service.registerUser(request));
    }

    @PostMapping("/registerOrganizer")
    public ResponseEntity<AuthenticationResponse> registerOrganizer(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerOrganizer(request));
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerAdmin(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
      return ResponseEntity.ok(service.authenticate(request));
    }

    @GetMapping
    List<RegisteredUser> getRegisteredUsers(){return repository.findAll();}
}
