package com.MotorMates.MotorMates.controller;

import com.MotorMates.MotorMates.entity.RiderProfile;
import com.MotorMates.MotorMates.service.RiderProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/forum/riderprofile")
public class RiderProfileController {

    private final RiderProfileService riderProfileService;
    @Autowired
    public RiderProfileController(RiderProfileService riderProfileService){
        this.riderProfileService = riderProfileService;
    }

    @GetMapping
    public List<RiderProfile>  getRiderProfile(){
        return riderProfileService.getRidersProfile();
    }

    @PostMapping
    public void newRider(@RequestBody RiderProfile riderProfile){
        riderProfileService.addNewRiderProfile(riderProfile);
    }

    @DeleteMapping(path = "{riderProfileId}")
    public void deleteRiderProfile(@PathVariable("riderProfileId") Long riderProfileId){
        riderProfileService.deleteRiderProfile(riderProfileId);
    }

    @PutMapping(path = "{riderProfileId}")
    public void updateRiderProfile(
            @PathVariable("riderProfileId") Long riderProfileId,
            @RequestParam (required = false) String typeOfRider,
            @RequestParam (required = false, defaultValue = "0") double totalDistance
    ) {
        riderProfileService.updateRiderProfile(riderProfileId, typeOfRider, totalDistance);
    }

}
