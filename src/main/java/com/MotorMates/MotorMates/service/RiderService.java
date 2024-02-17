package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.Rider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    public List<Rider> getRiders(){
        return List.of(
                new Rider("James",
                        "james123",
                        "james@bond.com",
                        "Racer",
                        4234.986,
                        60)
        );
    }
}
