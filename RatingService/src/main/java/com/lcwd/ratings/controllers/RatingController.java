package com.lcwd.ratings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.StringIdGenerator;
import com.lcwd.ratings.entities.Ratings;
import com.lcwd.ratings.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	//create rating
	@PostMapping
	public ResponseEntity<Ratings> create(@RequestBody Ratings rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
	}
	//get ratings
	@GetMapping
	public ResponseEntity<List<Ratings>>getRatings()
	{
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	//get ratings by user ID
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Ratings>>getRatingsByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(ratingService.getAllRatingsByUserId(userId));
	}
	//get ratings by hotel ID
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Ratings>>getRatingsByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(ratingService.getAllRatingsByHotelId(hotelId));
	}
}
