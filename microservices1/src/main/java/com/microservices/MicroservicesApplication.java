package com.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.repository.StudentRepository;

@SpringBootApplication
public class MicroservicesApplication {

	
	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
}
