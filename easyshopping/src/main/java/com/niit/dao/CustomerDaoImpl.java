package com.niit.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Authorities;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.Users;
@Repository
public class CustomerDaoImpl implements CustomerDao{
	
@Autowired(required=true)
private SessionFactory sessionFactory;

public CustomerDaoImpl()
{
	System.out.println("sessionfactory created"+sessionFactory);
	
}
public void savecustomer(Customer customer)
{
	Session session=sessionFactory.openSession();
	customer.getUsers().setEnabled(true);
	String username=customer.getUsers().getUsername();
	String role="ROLE_USER";
	Authorities authorities=new Authorities();
	authorities.setUsername(username);
	authorities.setRole(role);
	session.save(authorities);
	Cart cart=new Cart();
	customer.setCart(cart);
	cart.setCustomer(customer);
	
	session.save(customer);
	session.flush();
	session.close();
	
	
}



public Customer getCustomerByUsername(String username) {
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Users where username=?");
	query.setString(0, username);
	Users users=(Users)query.uniqueResult();
	//com.niit.model.Users 
	Customer customer=users.getCustomer();
	session.close();
	return customer;
	
}




}
