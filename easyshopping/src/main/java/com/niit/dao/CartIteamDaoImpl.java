package com.niit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.CartIteam;
@Repository
public class CartIteamDaoImpl implements CartIteamDao{
	@Autowired
private SessionFactory sessionFactory;

	public void addCartItem(CartIteam cartItem) {
	   Session session=sessionFactory.openSession();
	   session.saveOrUpdate(cartItem);
	   session.flush();
	   session.close();	
	}

}