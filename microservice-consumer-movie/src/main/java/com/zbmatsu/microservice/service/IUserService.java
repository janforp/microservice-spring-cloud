package com.zbmatsu.microservice.service;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.FeignClient;

import com.zbmatsu.config.FeignConfiguration;
import com.zbmatsu.microservice.entity.User;

import feign.Param;
import feign.RequestLine;

/**
 * 远程调用
 * webService
 * 访问另外一个项目上的服务
 */
@FeignClient(name="user-server", configuration=FeignConfiguration.class)
public interface IUserService {

	//configuration=FeignConfiguration.class,加了此配置才能使用该注解,
	// 若不用configuration=FeignConfiguration.class,则只能用RequestMapping
	@RequestLine("GET /user/{id}")

	/**
	 * 	负载均衡  name="user-server" 可以启动多个名字叫user-server的服务
	 * 	默认访问规则是:轮询
	 * 	todo:如何设置访问概率?
	 */
	@LoadBalanced
	User getUser(@Param("id") Long id);
}
