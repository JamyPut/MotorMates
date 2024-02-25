package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.RiderProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderProfileRepository
        extends JpaRepository<RiderProfile, Long> {
}
