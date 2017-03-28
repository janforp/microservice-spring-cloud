package com.zbmatsu.microservice.service.impl;

import org.springframework.stereotype.Service;

import com.zbmatsu.microservice.entity.User;
import com.zbmatsu.microservice.service.IUserService;


@Service("userService")
public class UserService implements IUserService{

	@Override
	public User getUserById(long id) {
		
		User user = new User();
		user.setId(id);
		user.setName("zhangsan");
		user.setAge(18);
		
		return user;
	}

	
}
