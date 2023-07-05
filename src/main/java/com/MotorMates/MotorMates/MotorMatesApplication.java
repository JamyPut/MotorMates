package com.MotorMates.MotorMates;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
			Rider james = new Rider("James", "james123", "james@bond.com", "Racer");
			riderRepository.save(james);
		};
	}

}
