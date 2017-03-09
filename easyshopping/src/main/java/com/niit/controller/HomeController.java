package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/aboutus")
	public String getAbout()
	{
		return "aboutus";
	}

	@RequestMapping("/home")
	public String gethome()
	{
		return "home";
	}
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout,
			Model model){
		if(error!=null)
			model.addAttribute("error","Invalid Username and Password.. Please enter valid username and password");
		if(logout!=null)
			model.addAttribute("logout","Loggedout successfully..");
		return "login";
	}
	
}