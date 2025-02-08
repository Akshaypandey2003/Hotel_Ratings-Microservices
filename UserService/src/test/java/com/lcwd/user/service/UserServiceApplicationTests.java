package com.lcwd.user.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.external.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	
	@Autowired
	private RatingService ratingService;
	@Test
	void createRating()
	{
		Rating rating = new Rating();
		rating.setRating(10);
		rating.setUserId("User id here");
		rating.setHotelId("Hotel id here");
		rating.setFeedback("RAtting created through feign client");
			
				
		Rating savedRating = ratingService.createRating(rating);
		System.out.println(savedRating);
	}

}
