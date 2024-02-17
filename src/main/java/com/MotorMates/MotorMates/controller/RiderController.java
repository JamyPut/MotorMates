package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.Rider;
import com.MotorMates.MotorMates.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/forum/rider")
public class RiderController {

    private final RiderService riderService;
    @Autowired
    public RiderController(RiderService riderService){
        this.riderService = riderService;
    }

    @GetMapping
    public List<Rider>  getRider(){
        return riderService.getRiders();
    }

}
