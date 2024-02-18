package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.Rider;
import com.MotorMates.MotorMates.repository.RiderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RiderService {

    private final RiderRepository riderRepository;

    @Autowired
    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public List<Rider> getRiders(){
        return riderRepository.findAll();
    }

    public void addNewRider(Rider rider) {
        Optional<Rider> riderByEmail = riderRepository
                .findRiderByEmail(rider.getEmail());
        Optional<Rider> riderByUsername = riderRepository
                .findRiderByUsername(rider.getUsername());
        if (riderByEmail.isPresent()){
            throw new IllegalStateException("Rider email already exists...");
        }
        else if (riderByUsername.isPresent()){
            throw new IllegalStateException("Rider username already exists...");
        }
        riderRepository.save(rider);
    }

    public void deleteRider(Long riderId){
        boolean exists = riderRepository.existsById(riderId);
        if (!exists){
            throw new IllegalStateException("Rider does not exist");
//            throw new IllegalStateException("Rider: " + riderId + " does not exist.")
        }
        riderRepository.deleteById(riderId);
    }

    @Transactional
    public void updateRider(Long riderId, String username, String email, String typeOfRider, double totalDistance){
        Rider rider = riderRepository.findById(riderId)
                .orElseThrow(() -> new IllegalStateException("RiderId: " + riderId + " not found."));

//        Using .isEmpty stops the put request from working. .length() > 0 works without issue.
        if (username != null && username.length() > 0 && !Objects.equals(rider.getUsername(), username)) {
            Optional<Rider> riderByUsername = riderRepository
                    .findRiderByUsername(username);
            if (riderByUsername.isPresent()) {
                throw new IllegalStateException("Rider already exists and username is taken.");
            }
            rider.setUsername(username);
        }

        if (email != null && email.length() > 0 && !Objects.equals(rider.getEmail(), email)){
            Optional<Rider> riderByEmail = riderRepository
                    .findRiderByEmail(email);
            if (riderByEmail.isPresent()){
                throw new IllegalStateException("Rider already exists and email is taken.");
            }
            rider.setEmail(email);
        }

        if (typeOfRider != null && typeOfRider.length() > 0 && !Objects.equals(rider.getTypeOfRider(), typeOfRider)){
            rider.setTypeOfRider(typeOfRider);
        }

        if (totalDistance != 0 && !Objects.equals(rider.getTotalDistance(), totalDistance)){
            rider.setTotalDistance(totalDistance);
        }
    }
}
