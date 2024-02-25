package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.Motorcycle;
import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.repository.MotorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public List<Motorcycle> getMotorcycles(){
        return motorcycleRepository.findAll();
    }

    public void addNewMotorcycle(Motorcycle motorcycle){
        motorcycleRepository.save(motorcycle);
    }




}
