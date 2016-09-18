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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 

import com.dao.AdminProductDAO;
import com.dao.ContactDAO;
import com.model.CartDetail;
import com.model.Contact;
import com.model.RegisterUser;

@Controller
public class LoginController {

	@Autowired
	AdminProductDAO aDAO;
	@Autowired
	ContactDAO cDAO;
	
	
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
//	@RequestMapping("/ContactUs")
//	public String showContactUs() 
//	{
//	return "ContactUs";
//	}
	@RequestMapping(value = "/ContactUs", method = RequestMethod.GET)  
	public ModelAndView showContactUs()
	{ 
		
		ModelAndView mvc=new ModelAndView("ContactUs","Contact",new Contact());
		
     return mvc;
	}
	@RequestMapping(value = "/ContactUs", method = RequestMethod.POST)  
	public ModelAndView ContactUs(Contact obj)
	{ 
		cDAO.saveContact(obj);
		ModelAndView mvc=new ModelAndView("Home","Contact",new Contact());
		
		
     return mvc;
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
			int size=0;
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
			    	  size=ob.size();
			    	 session.setAttribute("mycart",ob);
			    	 session.setAttribute("count", size);
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
