package com.MotorMates.MotorMates.entity;

import lombok.Data;

@Data
public class RegisteredUser {

    private Long id;
    private String loginName;
    private String LoginPassword;
    private String loginEmail;
}
