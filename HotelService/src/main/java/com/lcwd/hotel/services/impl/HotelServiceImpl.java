package com.lcwd.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exception.ResourceNotFoundException;
import com.lcwd.hotel.repository.HotelRepo;
import com.lcwd.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
   
	@Autowired
	private HotelRepo hotelRepo;
	@Override
	public Hotel create(Hotel hotel) {
		
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotel(String id) {
		// TODO Auto-generated method stub
		 
		return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found!!"));
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		
		return hotelRepo.findAll();
	}

}
