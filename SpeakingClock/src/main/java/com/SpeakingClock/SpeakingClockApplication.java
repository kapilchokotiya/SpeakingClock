package com.SpeakingClock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EnableAutoConfiguration
public class SpeakingClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingClockApplication.class, args);
	}

}
