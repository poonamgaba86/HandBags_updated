package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegisterUserDAO;
import com.dao.UserCredentialDAO;
import com.model.RegisterUser;
import com.model.UserCredential;




@Controller
public class RegisterController {
	
	@Autowired
	RegisterUserDAO rDAO;
	@Autowired
	UserCredentialDAO uDAO;
	@RequestMapping(value = "/Registerview", method = RequestMethod.GET)  
	public ModelAndView displayRegister()
	{ 
		System.out.println("welcome to register");
		ModelAndView mvc=new ModelAndView("Register","RegisterUser",new RegisterUser());
		
     return mvc;
	}
	@RequestMapping(value = "/Registerview", method = RequestMethod.POST)  
	public ModelAndView addRegister(RegisterUser ru)
	{ 
		
		String password=ru.getPassword();
		String uname=ru.getUserName();
		String role="USER_ROLE";
		boolean e=true;
		rDAO.saveUser(ru);
		UserCredential ucred= new UserCredential();
		ucred.setUserId(uname);
		ucred.setPassword(password);
		ucred.setRole(role);
		ucred.setEnable(e);
		uDAO.saveUsercred(ucred);
		
		
		ModelAndView mvc=new ModelAndView("Thanks","RegisterUser",new RegisterUser());
		
     return mvc;
	}
		
	

}
