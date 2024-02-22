package com.MotorMates.MotorMates.repository;

import com.MotorMates.MotorMates.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
