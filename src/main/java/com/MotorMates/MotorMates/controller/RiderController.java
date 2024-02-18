package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.Rider;
import com.MotorMates.MotorMates.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void newRider(@RequestBody Rider rider){
        riderService.addNewRider(rider);
    }

    @DeleteMapping(path = "{riderId}")
    public void deleteRider(@PathVariable("riderId") Long riderId){
        riderService.deleteRider(riderId);
    }

    @PutMapping(path = "{riderId}")
    public void updateRider(
            @PathVariable("riderId") Long riderId,
            @RequestParam(required = false) String username,
            @RequestParam (required = false) String email,
            @RequestParam (required = false) String typeOfRider,
            @RequestParam (required = false, defaultValue = "0") double totalDistance
    ) {
        riderService.updateRider(riderId, username, email, typeOfRider, totalDistance);
    }

}
