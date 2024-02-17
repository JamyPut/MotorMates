package com.MotorMates.MotorMates.service;

import com.MotorMates.MotorMates.entity.Rider;
import com.MotorMates.MotorMates.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Optional<Rider> riderByEmail= riderRepository
                .findRiderByEmail(rider.getEmail());
        if (riderByEmail.isPresent()){
            throw new IllegalStateException("Rider already exists...");
        }
        riderRepository.save(rider);
    }

    public void deleteRider(Long riderId){
        boolean exists = riderRepository.existsById(riderId);
        if (!exists){
            throw new IllegalStateException("Rider does not exist");
//            throw new IllegalStateException("Rider: " + riderId + " does not exists.")
        }
        riderRepository.deleteById(riderId);
    }
}
