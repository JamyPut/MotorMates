package com.MotorMates.MotorMates.configuration;

import com.MotorMates.MotorMates.entity.RiderProfile;
import com.MotorMates.MotorMates.repository.RiderProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RiderProfileConfig {

    @Bean
    CommandLineRunner commandLineRunner(RiderProfileRepository repository){
        return args -> {
            RiderProfile riderProfile1 = new RiderProfile(
                    "Racer",
                    4234.986
            );
            RiderProfile riderProfile2 = new RiderProfile(
                    "Tourer",
                    4125
            );

            repository.saveAll(
                    List.of(riderProfile1, riderProfile2)
            );
        };
    }
}
