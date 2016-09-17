package com.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.AdminProductDAO;
import com.model.CartDetail;
@Controller
public class LoginController {

	@Autowired
	AdminProductDAO aDAO;
	@Autowired
	
	
	@RequestMapping("/Home")
	public String showhome() 
	{
		System.out.println("welcome");
	return "Home";
	}
	@RequestMapping("/AboutUs")
	public String showAboutUs() 
	{
		System.out.println("welcome");
	return "AboutUs";
	}
	@RequestMapping("/ContactUs")
	public String showContactUs() 
	{
	return "ContactUs";
	}
	@RequestMapping("/Register")
	public String showRegister() 
	{
	return "Register";
	}

	@SuppressWarnings("unchecked")
	
	@RequestMapping("/Loginchecking")
	public String showadminlogin(HttpSession session,Model model) 
	{

		
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			
			//session.setAttribute("LoggedIn", "true");

			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			String page="";
			String role="ROLE_USER";
			for (GrantedAuthority authority : authorities) 
			{
			  
			     if (authority.getAuthority().equals(role)) 
			     {
			    	 String jsondata= aDAO.listAdProd();
			    	 model.addAttribute("dat",jsondata);
			    	 session.setAttribute("UserLoggedIn", "true");
			    	 session.setAttribute("userid",userName);
				 //page="Cart";
			    	 page="ShowProduct";
			    	 ArrayList<CartDetail> ob = new ArrayList<CartDetail>();
			    	 session.setAttribute("mycart",ob);
			    	// session.setAttribute("cartsize",cartDAO.cartsize((int)session.getAttribute("userId")));
			     }
			     else 
			     {
			    	 session.setAttribute("Administrator", "true");
			    	 session.setAttribute("userid",userName);
			    	 page="AdminLogin";
				
			    }
			}
			return page;
		}

	
	
}
