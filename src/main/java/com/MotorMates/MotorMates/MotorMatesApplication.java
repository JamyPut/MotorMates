package com.MotorMates.MotorMates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MotorMatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotorMatesApplication.class, args);
	}
	@GetMapping
	private String hello(){
		return "Hello World, and welcome to the MotorMates forum";
	}

}
