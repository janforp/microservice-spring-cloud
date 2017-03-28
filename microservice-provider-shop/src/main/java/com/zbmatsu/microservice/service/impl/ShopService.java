package com.zbmatsu.microservice.service.impl;

import com.zbmatsu.microservice.entity.Shop;
import org.springframework.stereotype.Service;

import com.zbmatsu.microservice.service.IShopService;

import java.math.BigDecimal;
@Service("userService")
public class ShopService implements IShopService {

	@Override
	public Shop getShopById(long id) {

		Shop shop = new Shop();
		shop.setShopId(id);
		shop.setShopTitle("java书");
		shop.setShopPrice(new BigDecimal(18.8));

		return shop;
	}
}
