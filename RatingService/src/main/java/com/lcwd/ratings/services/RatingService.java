package com.lcwd.ratings.services;

import java.util.List;

import com.lcwd.ratings.entities.Ratings;

public interface RatingService {

	//create#
	public Ratings create(Ratings ratings);
	//getAllratings
	public List<Ratings> getAllRatings();
	//get all by user id
	public List<Ratings> getAllRatingsByUserId(String userId);
	//get all by hotel id
	public List<Ratings> getAllRatingsByHotelId(String hotelId);
	
	
}
