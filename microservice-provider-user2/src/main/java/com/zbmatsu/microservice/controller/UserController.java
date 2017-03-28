package com.zbmatsu.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zbmatsu.microservice.entity.User;
import com.zbmatsu.microservice.service.impl.UserService;

@RestController
public class UserController {

	@Autowired
	protected UserService userService;
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id){
		
		System.out.println("user2............");
		
		return userService.getUserById(id);
	}
}
