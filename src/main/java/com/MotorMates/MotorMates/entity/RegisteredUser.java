package com.MotorMates.MotorMates.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Entity
public class RegisteredUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "registration_sequence",
            sequenceName = "registration_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "registration_sequence"
    )
    private Long registeredId;
    private String loginName;
    private String loginMail;
    private String loginPassword;
    @Enumerated(EnumType.STRING)
    private RegisteredRoles registeredRoles;
    private Boolean locked;
    private Boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(registeredRoles.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return loginPassword;
    }

    @Override
    public String getUsername() {
        return loginName;
    }


//    public String getLoginName() {
//        return loginName;
//    }
//
//    public String getLoginPassword() {
//        return loginPassword;
//    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Long getRegisteredId() {
        return registeredId;
    }

    public void setRegisteredId(Long registeredId) {
        this.registeredId = registeredId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginMail() {
        return loginMail;
    }

    public void setLoginMail(String loginMail) {
        this.loginMail = loginMail;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public RegisteredRoles getRegisteredRoles() {
        return registeredRoles;
    }

    public void setRegisteredRoles(RegisteredRoles registeredRoles) {
        this.registeredRoles = registeredRoles;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RegisteredUser(){

    }
    public RegisteredUser(String loginName, String loginMail, String loginPassword, RegisteredRoles registeredRoles, Boolean locked, Boolean enabled) {
        this.loginName = loginName;
        this.loginMail = loginMail;
        this.loginPassword = loginPassword;
        this.registeredRoles = registeredRoles;
        this.locked = locked;
        this.enabled = enabled;
    }
}
