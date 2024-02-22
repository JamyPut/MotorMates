package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.RiderProfile;
import com.MotorMates.MotorMates.repository.RiderProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RiderProfileService {

    private final RiderProfileRepository riderProfileRepository;

    @Autowired
    public RiderProfileService(RiderProfileRepository riderProfileRepository) {
        this.riderProfileRepository = riderProfileRepository;
    }

    public List<RiderProfile> getRidersProfile(){
        return riderProfileRepository.findAll();
    }

    public void addNewRiderProfile(RiderProfile riderProfile) {
        riderProfileRepository.save(riderProfile);
    }

    public void deleteRiderProfile(Long riderProfileId){
        boolean exists = riderProfileRepository.existsById(riderProfileId);
        if (!exists){
            throw new IllegalStateException("RiderProfile does not exist");
//            throw new IllegalStateException("RiderProfile: " + riderProfileId + " does not exist.")
        }
        riderProfileRepository.deleteById(riderProfileId);
    }

    @Transactional
    public void updateRiderProfile(Long riderProfileId, String typeOfRider, double totalDistance){
        RiderProfile riderProfile = riderProfileRepository.findById(riderProfileId)
                .orElseThrow(() -> new IllegalStateException("RiderId: " + riderProfileId + " not found."));


/*        Updating username and email and checking if name already exists

if (username != null && !username.isEmpty() && !Objects.equals(riderProfile.getUsername(), username)) {
            Optional<RiderProfile> riderByUsername = riderProfileRepository
                    .findRiderByUsername(username);
            if (riderByUsername.isPresent()) {
                throw new IllegalStateException("RiderProfile already exists and username is taken.");
            }
            riderProfile.setUsername(username);
        }

        if (email != null && !email.isEmpty() && !Objects.equals(riderProfile.getEmail(), email)){
            Optional<RiderProfile> riderByEmail = riderProfileRepository
                    .findRiderByEmail(email);
            if (riderByEmail.isPresent()){
                throw new IllegalStateException("RiderProfile already exists and email is taken.");
            }
            riderProfile.setEmail(email);
        }*/

        if (typeOfRider != null && !typeOfRider.isEmpty() && !Objects.equals(riderProfile.getTypeOfRider(), typeOfRider)){
            riderProfile.setTypeOfRider(typeOfRider);
        }

        if (totalDistance != 0 && !Objects.equals(riderProfile.getTotalDistance(), totalDistance)){
            riderProfile.setTotalDistance(totalDistance);
        }
    }
}
