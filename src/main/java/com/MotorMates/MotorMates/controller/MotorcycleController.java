package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.Motorcycle;
import com.MotorMates.MotorMates.service.MotorcycleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/forum/motorcycle")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public List<Motorcycle> getMotorcycle(){
        return motorcycleService.getMotorcycles();
    }

    @PostMapping
    public void newMotorcycle(@RequestBody Motorcycle motorcycle) {
        motorcycleService.addNewMotorcycle(motorcycle);
    }
}
