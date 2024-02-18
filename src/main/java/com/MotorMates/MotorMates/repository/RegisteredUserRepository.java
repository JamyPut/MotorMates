package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RegisteredUserRepository {
    Optional<RegisteredUser> findByEmail(String email);
}
