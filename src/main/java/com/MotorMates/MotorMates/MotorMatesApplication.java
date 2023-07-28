package com.MotorMates.MotorMates;

import com.MotorMates.MotorMates.entity.Event;
import com.MotorMates.MotorMates.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import com.MotorMates.MotorMates.repository.RiderRepository;
import com.MotorMates.MotorMates.entity.Rider;

@SpringBootApplication
public class MotorMatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorMatesApplication.class, args);
	}
	@GetMapping(path = "/")
	public String hello(){
		return "Hello World";
	}

	@Bean
	CommandLineRunner commandLineRunner(RiderRepository riderRepository){
		return args -> {
			Rider james = new Rider("James", "james123", "james@bond.com", "Racer", 4234.986, 60);
			riderRepository.save(james);
		};
	}

	// je kan geen 2 beans tegelijk hebben. nog niet opgelost...
//	@Bean
//	CommandLineRunner commandLineRunner(EventRepository eventRepository){
//		return args -> {
//			Event dutchRideout = new Event("Nuenen", 2000, "12 juli 2023");
//			eventRepository.save(dutchRideout);
//		};
//	}

}
