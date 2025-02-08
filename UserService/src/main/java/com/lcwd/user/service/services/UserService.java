package com.lcwd.user.service.services;

import java.util.List;

import com.lcwd.user.service.entities.User;

public interface UserService {

	
	//User operations
  User saveUser(User user); 
  
  //Get all the users
  List<User> getAllUser();
  
  
  //GEt User by Id
  User getUserById(String id);
  
  String deleteUser(User user);
  
  User updateUser(User user);
}
