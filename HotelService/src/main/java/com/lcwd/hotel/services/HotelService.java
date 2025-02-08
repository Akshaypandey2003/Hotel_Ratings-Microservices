package com.lcwd.hotel.services;

import java.util.List;

import com.lcwd.hotel.entities.Hotel;

public interface HotelService {

	//create method
	 Hotel create(Hotel hotel);
	 
	//Get single hotel
	 Hotel getHotel(String id);
	 
	 //Get all hotels 
	 List<Hotel> getAllHotel();
	 
	 
}
