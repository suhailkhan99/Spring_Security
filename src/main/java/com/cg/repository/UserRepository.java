package com.cg.repository;

import org.springframework.stereotype.Repository;

import com.cg.model.User;



@Repository
public class UserRepository {
	
	
	 public User findUserByEmail(String email){
	        return new User(email,"123456","Farhan","Tanvir");
	    }

}
