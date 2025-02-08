package com.lcwd.user.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.interceptor.LoggingCacheErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.*;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//create
	  @PostMapping
	 public ResponseEntity<User> createUser(@RequestBody User user)
	 {
		  System.out.println(user);
		 User user1 = userService.saveUser(user);
		 return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	 }
	  
	//GEt single user
	  
	  int retryCount = 1;
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//	@Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable String userId)
	 {
		 User user1 = userService.getUserById(userId);
		 logger.info("Retry count is: {}",retryCount);
			retryCount++;

		 return ResponseEntity.ok(user1);
	 }
	
	//creating fallback method for circuit breaker
	
	public ResponseEntity<User> ratingHotelFallback(String userId,Exception exception)
	{
			   logger.info("Fall back is executed!!",exception.getMessage());
	   
	   User user = new User();
	   user.setEmail("DummyEmail@gmail.com");
	   user.setName("DummyNAme");
	   user.setAbout("THis is dummy user");
	   user.setId("145896");
	   
	   return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	//Get all user
	@GetMapping
	 public ResponseEntity<List<User>> getAllUser()
	 {
		 List<User>users = userService.getAllUser();
		 return ResponseEntity.ok(users);
	 }
}
