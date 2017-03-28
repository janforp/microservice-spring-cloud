package com.zbmatsu.microservice.controller;

import com.zbmatsu.microservice.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zbmatsu.microservice.service.impl.ShopService;

@RestController
public class ShopController {

	@Autowired
	protected ShopService shopService;
	
	@GetMapping("/shop/{shopId}")
	public Shop getShop(@PathVariable Long shopId){
		
		System.out.println("shop............");
		
		return shopService.getShopById(shopId);
	}
}
