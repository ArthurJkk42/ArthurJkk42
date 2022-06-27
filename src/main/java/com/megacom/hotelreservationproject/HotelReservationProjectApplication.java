package com.megacom.hotelreservationproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients("com.megacom.hotelreservationproject.microservices")
@SpringBootApplication
public class HotelReservationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationProjectApplication.class, args);
	}
}
