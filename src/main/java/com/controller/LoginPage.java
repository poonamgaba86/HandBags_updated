package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.login;

@Controller
public class LoginPage
{
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String displayLogin(@ModelAttribute("login")login log)
	{ 
    return "Login"; 
	}
		
		@RequestMapping( value="/Login" ,method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")login log, 
	   ModelMap model) {
			model.addAttribute("first_name",log.getUsername());
			
			model.addAttribute("last_name",log.getPassword());
			
			
		
	      return "Thanks";
	   }
	

}

	


