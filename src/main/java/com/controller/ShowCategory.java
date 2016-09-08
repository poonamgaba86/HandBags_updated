package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.model.login;
import com.model.Category;
@Controller
public class ShowCategory {
	@RequestMapping(value = "/Category", method = RequestMethod.GET)
	public String displayCategory(@ModelAttribute("category")Category cat)
	{ 
    return "Category"; 
	}
		
		@RequestMapping( value="/Category" ,method = RequestMethod.POST)
	   public String addcategory(@ModelAttribute("SpringWeb")Category cat, 
	   ModelMap model) {
			model.addAttribute("Category id",cat.getCategoryid());
			
			model.addAttribute("Category name",cat.getCategorynm());
			model.addAttribute("Description",cat.getCategorydesc());
			
			
			
		
	      return "Thanks";
	   }
	
	

	

}
