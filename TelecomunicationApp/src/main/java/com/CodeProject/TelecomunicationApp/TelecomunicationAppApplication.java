package com.CodeProject.TelecomunicationApp;

import com.CodeProject.TelecomunicationApp.Repos.chargingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.CodeProject.TelecomunicationApp.Entities")
public class TelecomunicationAppApplication {
	@Autowired
    chargingRepository repo;


	public static void main(String[] args) {
		SpringApplication.run(TelecomunicationAppApplication.class, args);
	}

}
