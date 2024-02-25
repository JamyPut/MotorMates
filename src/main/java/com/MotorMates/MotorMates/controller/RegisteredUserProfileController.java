package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.entity.RiderProfile;
import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum/auth/riderprofile")
public class RegisteredUserProfileController {

    @Autowired
    private RegisteredUserRepository registeredUserRepository;

//    @PostMapping("/storeRiderProfile")
//    public RegisteredUser storeRiderProfile(@RequestBody RegisteredUser registeredUser) {
//        RiderProfile riderProfile = registeredUser.getRiderProfile();
//
//        if (riderProfile != null) {
//            riderProfile.setRegisteredUser(registeredUser);
//        }
//
//        return registeredUserRepository.save(registeredUser);
//    }
}
