package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.Motorcycle;
import com.MotorMates.MotorMates.entity.RegisteredUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

}
