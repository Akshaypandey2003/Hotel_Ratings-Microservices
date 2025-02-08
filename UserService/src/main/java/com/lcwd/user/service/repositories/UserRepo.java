package com.lcwd.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.user.service.entities.User;

public interface UserRepo extends JpaRepository<User,String>{

	//we can also implement any custom method or query 
}
