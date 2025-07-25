package com.lcwd.hotel.controllers;

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

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
  
	//create
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	//Get single
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
	}
	
	//get ALl
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel()
	{
		List<Hotel> hotels = hotelService.getAllHotel();
		return ResponseEntity.ok(hotels);
	}
}
