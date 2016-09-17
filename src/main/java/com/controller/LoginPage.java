package com.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dao.RegisterUserDAO;
import com.model.UserCredential;



@Controller

public class LoginPage
{
	@Autowired
	RegisterUserDAO  rDAO;
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public String displayLogin()
	{ 
    return "Login"; 
	}

	@RequestMapping(value = "/perform_logout")
	public String disLogout()
	{ 
    return "Home"; 
	}

}

	


