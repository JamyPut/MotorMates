package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.Motorcycle;
import com.MotorMates.MotorMates.entity.RegisteredUser;
import com.MotorMates.MotorMates.repository.MotorcycleRepository;
import com.MotorMates.MotorMates.repository.RegisteredUserRepository;
import com.MotorMates.MotorMates.service.MotorcycleService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/forum/motorcycle")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;
    private final MotorcycleRepository motorcycleRepository;
    private final RegisteredUserRepository registeredUserRepository;

    public MotorcycleController(MotorcycleService motorcycleService, MotorcycleRepository motorcycleRepository, RegisteredUserRepository registeredUserRepository) {
        this.motorcycleService = motorcycleService;
        this.motorcycleRepository = motorcycleRepository;
        this.registeredUserRepository = registeredUserRepository;
    }

    @GetMapping
    public List<Motorcycle> getMotorcycle(){
        return motorcycleService.getMotorcycles();
    }

    @PostMapping
    public void newMotorcycle(@RequestBody Motorcycle motorcycle) {
        motorcycleService.addNewMotorcycle(motorcycle);
    }

    @PutMapping("/{motorcycleId}/pair/{registeredUserId}")
    Motorcycle pairMotorcycleToRegisteredUser(
            @PathVariable Long motorcycleId,
            @PathVariable Long registeredUserId
    ){
        Optional<Motorcycle> motorcycleOptional = motorcycleRepository.findById(motorcycleId);
        Optional<RegisteredUser> registeredUserOptional = registeredUserRepository.findById(registeredUserId);

        if (motorcycleOptional.isPresent() && registeredUserOptional.isPresent()) {
            Motorcycle motorcycle = motorcycleOptional.get();
            RegisteredUser registeredUser = registeredUserOptional.get();
            motorcycle.pairToRegisteredUser(registeredUser);
            return motorcycleRepository.save(motorcycle);
        } else {
            // Handle the case when either Motorcycle or RegisteredUser is not found
            // You can throw an exception, return an appropriate response, or handle it according to your needs.
            // For example:
            throw new EntityNotFoundException("Motorcycle or RegisteredUser not found");
        }
    }

}
