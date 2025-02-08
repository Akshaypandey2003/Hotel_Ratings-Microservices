package com.lcwd.ratings.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.ratings.entities.Ratings;

public interface RatingRepo extends MongoRepository<Ratings,String>{

	//Custom finder methods
	List<Ratings> findByUserId(String userId);
	List<Ratings> findByHotelId(String hotelId);
}
