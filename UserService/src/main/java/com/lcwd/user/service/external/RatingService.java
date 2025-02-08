package com.lcwd.user.service.external;

import java.util.Map;
import java.util.Objects;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	//get
	
	
	//post
	@PostMapping("/ratings")
	Rating createRating(Rating rating);
	
	//put
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	//delete
	@DeleteMapping("/ratings/{ratingId}")
	void deleteRating(@PathVariable String ratingId);
}
