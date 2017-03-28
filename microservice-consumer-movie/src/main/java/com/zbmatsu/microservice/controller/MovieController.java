package com.zbmatsu.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zbmatsu.microservice.entity.User;
import com.zbmatsu.microservice.service.IUserService;

@RestController
public class MovieController {

	@Autowired
	protected IUserService userService;
	
	//commandProperties 将此方法和fallbackMethod 放入同一个线程中,减少一个线程开销@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"),这是写死的
	@HystrixCommand(fallbackMethod="getUserFallback", commandProperties=@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE"))
	@GetMapping("/movie/user/{id}")
	public User getUser(@PathVariable Long id){
		
		return userService.getUser(id);
	}


	/**
	 * 把user1/user2的服务器停了,就可以看见效果
	 * @param id
	 * @return
	 */
	public User getUserFallback(Long id){
		
		User user = new User();
		user.setId(0);
		return user;
	}
	
}
