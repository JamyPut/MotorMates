package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.Motorcycle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {
}
