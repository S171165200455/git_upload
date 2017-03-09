package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartIteamDao;
import com.niit.model.CartIteam;
@Service
public class CartIteamServiceImpl implements CartIteamService {
	@Autowired
private CartIteamDao cartIteamDao;
	public void addCartItem(CartIteam cartItem) {
	  cartIteamDao.addCartItem(cartItem);
		
	}

}