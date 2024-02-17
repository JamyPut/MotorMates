package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RiderRepository
        extends JpaRepository<Rider, Long> {

    Optional<Rider> findRiderByEmail(String email);
}
