package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.RegisteredUser;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RegisteredUserRepository extends JpaRepository<RegisteredUser, Long> {
    Optional<RegisteredUser> findByLoginMail(String loginMail);
}
