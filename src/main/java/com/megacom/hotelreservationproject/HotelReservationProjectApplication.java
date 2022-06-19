package com.megacom.hotelreservationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HotelReservationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationProjectApplication.class, args);
	}
}
