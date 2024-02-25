package com.MotorMates.MotorMates.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class RegisteredUser implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "registeredUser_sequence",
            sequenceName = "registeredUser_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "registeredUser_sequence"
    )
    private Long id;
    private String loginName;
    private String loginPassword;
    private String loginEmail;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Set<Motorcycle> getMotorcycles() {
        return motorcycles;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "registeredUser")
    private Set<Motorcycle> motorcycles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return loginPassword;
    }

    @Override
    public String getUsername() {
        return loginEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
