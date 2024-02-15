package com.MotorMates.MotorMates;

import com.MotorMates.MotorMates.entity.Event;
//import com.MotorMates.MotorMates.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import com.MotorMates.MotorMates.repository.RiderRepository;
import com.MotorMates.MotorMates.entity.Rider;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MotorMatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorMatesApplication.class, args);
	}
	@GetMapping(path = "/")
	private String hello(){
		return "Hello World, and welcome to the motormates Forum";
	}

	@Bean
	CommandLineRunner commandLineRunner(RiderRepository riderRepository){
		return args -> {
			Rider james = new Rider("James", "james123", "james@bond.com", "Racer", 4234.986, 60);
			Rider joanna = new Rider("Joanna", "joanna123", "joanna@live.com", "Tourer", 423.98, 40);
			riderRepository.saveAll(
					List.of(james, joanna)
			);
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
