package com.MotorMates.MotorMates.configuration;

import com.MotorMates.MotorMates.entity.Rider;
import com.MotorMates.MotorMates.repository.RiderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RiderConfig {

    @Bean
    CommandLineRunner commandLineRunner(RiderRepository repository){
        return args -> {
            Rider james = new Rider(
                    "James",
                    "james123",
                    "james@bond.com",
                    "Racer",
                    4234.986
            );
            Rider joanna = new Rider(
                    "Joanna",
                    "Joanna123",
                    "Joanna@bond.com",
                    "Tourer",
                    4125
            );

            repository.saveAll(
                    List.of(james, joanna)
            );
        };
    }
}
