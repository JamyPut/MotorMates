package com.MotorMates.MotorMates.request;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/forum")
@PreAuthorize("hasRole('ADMIN')")
public class AdminGetUserList {

    private final RegisteredUserRepository repository;

    public AdminGetUserList(RegisteredUserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/admin/registeredUsers")
    @PreAuthorize("hasRole('ADMIN')")
    List<RegisteredUser> getRegisteredUsers(){return repository.findAll();}
}
