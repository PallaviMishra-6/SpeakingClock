package com.TimeConversion.SpeakingClock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.TimeConversion.SpeakingClock.Service","com.TimeConversion.SpeakingClock.Controller","com.TimeConversion.SpeakingClock.Exception"})
public class SpeakingClockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingClockApplication.class, args);
	}

}
