package com.niit.service;

import com.niit.model.Customer;

public interface CustomerService {

 void savecustomer(Customer customer);
 
 public Customer getCustomerByUsername(String username);
 }
