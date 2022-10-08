package com.example.ratMazeproblem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ratMazeproblem.service.FetchandPrintSolutionImpl;

@SpringBootApplication
public class RatMazeproblemApplication implements CommandLineRunner {

	@Value("#{environment['status']}")
	private String status;
	
	@Autowired
	private FetchandPrintSolutionImpl fetchSolution;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RatMazeproblemApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
		fetchSolution.getTrajectory(status);
	}
}
