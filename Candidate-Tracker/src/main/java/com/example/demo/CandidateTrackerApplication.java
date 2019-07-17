package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.demo.repository")
@SpringBootApplication
public class CandidateTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidateTrackerApplication.class, args);
	}

}

