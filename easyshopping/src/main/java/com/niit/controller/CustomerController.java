package com.niit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Customer;
import com.niit.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired(required=true)
	private CustomerService customerService;
	
	public CustomerController()
	{
		System.out.println("inside customer controller");
		
	}

	@RequestMapping("/all/registrationForm")
	public String GetRegistrationForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "registercustomer";
	}

	@RequestMapping("/all/registerCustomer")
	public String registerCustomer(@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult result,
			Model model) {
		if (result.hasErrors())
			return "registercustomer";
		try {
			customerService.savecustomer(customer);

		} catch (Exception e) {
			model.addAttribute("duplicateUsername", "Username alreadyexists.Pleasenenter different username");
			return "registercustomer";
		}
		return "home";
	}

}
