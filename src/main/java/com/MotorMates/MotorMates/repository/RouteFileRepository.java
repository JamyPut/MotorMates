package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.RouteFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteFileRepository extends JpaRepository<RouteFile, String> {
}
