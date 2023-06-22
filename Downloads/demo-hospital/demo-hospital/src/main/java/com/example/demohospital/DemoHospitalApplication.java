package com.example.demohospital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoHospitalApplication {
	   static Logger logger = LoggerFactory.getLogger(DemoHospitalApplication.class);

	public static void main(String[] args) {
		 
		logger.trace("Inside trace logging");
		logger.debug("Inside debug logging");
		logger.info("Inside info logging");
		logger.warn("Inside warn logging");
		logger.error("Inside error logging");
		SpringApplication.run(DemoHospitalApplication.class, args);
	}

}
