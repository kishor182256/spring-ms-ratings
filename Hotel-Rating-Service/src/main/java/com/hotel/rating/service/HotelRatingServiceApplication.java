package com.hotel.rating.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelRatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelRatingServiceApplication.class, args);
		System.out.println("================");
		System.out.println("Hotel Rating Service Application Started");
		System.out.println("================");
	}

}
