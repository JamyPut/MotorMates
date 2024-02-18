package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.request.RegistrationRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/forum/register")
public class RegistrationController {

    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }
}
