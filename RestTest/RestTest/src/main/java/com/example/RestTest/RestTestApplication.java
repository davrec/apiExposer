package com.example.RestTest;

import com.example.RestTest.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories("com.example.RestTest.Repository")
public class RestTestApplication {
	@Autowired
	ReservationRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(RestTestApplication.class, args);
	}


}
