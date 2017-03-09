package com.niit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CustomerDao;
import com.niit.model.Customer;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired(required=true)
	private CustomerDao customerDao;
	
	public CustomerServiceImpl()
	{
		System.out.println("customerservice impl");
	}
	
	public void savecustomer(Customer customer)
	{
	 customerDao.savecustomer(customer);
	}
	
	public Customer getCustomerByUsername(String username){
		return customerDao.getCustomerByUsername(username);
	}

}
