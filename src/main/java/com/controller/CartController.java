package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AdminProductDAO;
import com.dao.CartDAO;
import com.dao.RegisterUserDAO;
import com.google.gson.Gson;
import com.model.AdminProduct;
import com.model.CartDetail;

@Controller

public class CartController {
	@Autowired
	AdminProductDAO adProdDAO;
	@Autowired
	CartDAO cDAO;
	
	@Autowired
	RegisterUserDAO rdao;
	
	@RequestMapping(value = "/AddToCart", method = RequestMethod.GET)
	public ModelAndView showCart(@RequestParam("adpid") int apid, HttpSession session) {

		AdminProduct adp = adProdDAO.DispRecord(apid);
		CartDetail cd = new CartDetail();
		cd.setPid(adp.getAproductId());
		cd.setPname(adp.getAprodName());
		cd.setPrice(adp.getAprice());
		//CartDetail cartinf = cDAO.addcart(cd);
		List<CartDetail>	li	=  (ArrayList<CartDetail>)session.getAttribute("mycart");
		li.add(cd);
		Gson gsonli = new Gson();
		String gs = gsonli.toJson(li);
		session.setAttribute("cart", gs);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
		mv.addObject("cart", gs);
		

		System.out.println(session.getAttribute("cart"));
		return mv;

	}

	@RequestMapping(value = "/RemoveFromCart", method = RequestMethod.GET)
	public ModelAndView removeCart(@RequestParam("pid") int id,HttpSession session)
	{
		List<CartDetail> ld=(ArrayList<CartDetail>)session.getAttribute("mycart");
		
//		CartDetail d=li.get(id);
//		System.out.println(d);
	//	System.out.println(li.indexOf(id));
		
		//session.removeAttribute("cid");
		//cDAO.remcart(cid);
		
		ListIterator<CartDetail> lit=(ListIterator<CartDetail>) ld.listIterator();
		while(lit.hasNext())
		{
		CartDetail d=lit.next();
		if(d.getPid()==id)
		{
			
			System.out.println(ld.indexOf(d));
			ld.remove(ld.indexOf(d));
			break;
		}
		}
		session.setAttribute("mycart",ld);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
		Gson gsonli = new Gson();
		String gs = gsonli.toJson(ld);
		mv.addObject("cart",gs);
		return mv;

	}
	@RequestMapping(value = "/OrderConfirmation", method = RequestMethod.GET)
	public ModelAndView orderConfirm(HttpSession session)
	{
		List<CartDetail>	li	=  (ArrayList<CartDetail>)session.getAttribute("mycart");
	//	li.add(cd);
		Gson gsonli = new Gson();
		String gs = gsonli.toJson(li);
		session.setAttribute("cart", gs);
			ModelAndView  mv = new ModelAndView("OrderConfirmation","CartDetail",new CartDetail());
			mv.addObject("cart",gs);
			mv.addObject("useraddr",rdao.address((String)session.getAttribute("userid")));
			return mv;
	}
	@RequestMapping(value = "/AddToCartgoback", method = RequestMethod.GET)
	public ModelAndView cartgoback(HttpSession session)
	{
		
		
		List<CartDetail>	li	=  (ArrayList<CartDetail>)session.getAttribute("mycart");
	
		Gson gsonli = new Gson();
		String gs = gsonli.toJson(li);
		session.setAttribute("cart", gs);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
		mv.addObject("cart", gs);
		

		System.out.println(session.getAttribute("cart"));
		return mv;
			
	}
	@RequestMapping(value = "/PaymentConfirmed", method = RequestMethod.GET)
	public String paymentconfirm(HttpSession session)
	{
		
		
//		List<CartDetail>	li	=  (ArrayList<CartDetail>)session.getAttribute("mycart");
//	
//		Gson gsonli = new Gson();
//		String gs = gsonli.toJson(li);
//		session.setAttribute("cart", gs);
//		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
//		mv.addObject("cart", gs);
//		
//
//		System.out.println(session.getAttribute("cart"));
		return "/PaymentConfirmed";
			
	}
	
	
	

}
