package com.lcwd.ratings.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lcwd.ratings.entities.Ratings;
import com.lcwd.ratings.repositories.RatingRepo;
import com.lcwd.ratings.services.RatingService;


@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	private RatingRepo ratingRepo;
	@Override
	public Ratings create(Ratings ratings) {
		// TODO Auto-generated method stub
		return  ratingRepo.save(ratings);
	}

	@Override
	public List<Ratings> getAllRatings() {
		// TODO Auto-generated method stub
		return ratingRepo.findAll();
	}

	@Override
	public List<Ratings> getAllRatingsByUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Ratings> getAllRatingsByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepo.findByHotelId(hotelId);
	}

}
