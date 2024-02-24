package com.MotorMates.MotorMates.Authentication;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum/auth")
@RequiredArgsConstructor
 class AuthenticationController {

   private final AuthenticationService service;

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
}
