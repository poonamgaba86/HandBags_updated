package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;

@Controller
public class RegisterController {
	
	@RequestMapping(value = "/Register", method = RequestMethod.GET)  
	public String displayRegister(@ModelAttribute("register")User user)
	{ 
    return "Register"; 
	}
		
		@RequestMapping( value="/Register" ,method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")User user, 
	   ModelMap model) {
			model.addAttribute("first_name",user.getFirst_name());
			
			model.addAttribute("last_name",user.getLast_name());
			
			model.addAttribute("password",user.getPassword());
			
			model.addAttribute("password_confirmation",user.getPassword_confirmation());
			model.addAttribute("email_id",user.getEmail_id());
		
	      return "Thanks";
	   }
	

}
