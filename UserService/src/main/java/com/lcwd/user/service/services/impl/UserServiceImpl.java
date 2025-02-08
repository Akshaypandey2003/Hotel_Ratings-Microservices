package com.lcwd.user.service.services.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.HotelService;
import com.lcwd.user.service.repositories.UserRepo;
import com.lcwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	
	//Client to make request to rating service to fetch the user ratings
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private HotelService hotelService;
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
	    user.setId(id);
	    
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with Given id not found !!"));
		//fetch ratings from rating service
		//To fetch the ratings associated with this user now we will have to make a request to rating service 
		//through some client
		 
	     Rating[] ratings = restTemplate.getForObject
		("http://RATING-SERVICE/ratings/user/"+user.getId(),
				Rating[].class);
	     
	     logger.info("{} ",ratings);
	     
	     List<Rating> list = Arrays.stream(ratings).toList();
	    
	     List<Rating> ratingList = list.stream().map(rating->{
	    	  //api call to get hotel details
	    	 //http://localhost:8082/hotels
//	    ResponseEntity<Hotel> forEntity =
//	    		restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class);
	    	  
//	   Hotel hotel =  forEntity.getBody();
	    	 
	    	 Hotel hotel = hotelService.getHotel(rating.getHotelId());
	   
//	   logger.info("Response: {} ",forEntity.getStatusCode());
	   
	      rating.setHotel(hotel);
	      return rating;
	     }).collect(Collectors.toList());
	   
	     user.setRatings(ratingList);
	    
		
		return user;
	}

	@Override
	public String deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
