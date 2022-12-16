package com.confident.silverconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SilverconnectApplication {
	public static void main(String[] args) {
		SpringApplication.run(SilverconnectApplication.class, args);
	}
}
