package com.controller;

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
import com.model.AdminProduct;
import com.model.CartDetail;

@Controller

public class CartController 
{
	@Autowired
	AdminProductDAO adProdDAO;
	@Autowired
	CartDAO cDAO;
	@RequestMapping(value="/AddToCart",method = RequestMethod.GET)
	public ModelAndView showCart(@RequestParam("adpid")int apid) 
	{
		
		AdminProduct adp=adProdDAO.DispRecord(apid);
		CartDetail cd= new CartDetail();
	cd.setPid(adp.getAproductId());
		cd.setPname(adp.getAprodName());
	cd.setPrice(adp.getAprice());
	String cartinf=cDAO.addcart(cd);
	ModelAndView mv= new ModelAndView("Cart","CartDetail",new CartDetail());
		mv.addObject("cart",cartinf);
		
		return mv;
		
		
		
		
	}
	@RequestMapping(value="/RemoveFromCart",method = RequestMethod.GET)
	public ModelAndView removeCart(@RequestParam("ctpid")int cid) 
	{
		cDAO.remcart(cid);
		ModelAndView mv= new ModelAndView("cart","CartDetail",new CartDetail());
		return mv;
		
		
		
		
		
		
	}

}
