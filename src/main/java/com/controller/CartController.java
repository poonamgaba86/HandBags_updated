package com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	
	public int getGrandTotal(ArrayList<CartDetail> cd)
	{
		ListIterator<CartDetail> itr=cd.listIterator();
		int grandtotal=0;
		while(itr.hasNext())
		{
			CartDetail cd1=(CartDetail)itr.next();
			grandtotal=grandtotal+(cd1.getQty()*cd1.getPrice());
			
		}
		return grandtotal;
	}

	@RequestMapping(value = "/AddToCart", method = RequestMethod.GET)
	public ModelAndView showCart(@RequestParam("adpid") int apid, HttpSession session) {

		AdminProduct adp = adProdDAO.DispRecord(apid);
		CartDetail cd = new CartDetail();
		cd.setPid(adp.getAproductId());
		cd.setPname(adp.getAprodName());
		cd.setPrice(adp.getAprice());
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
		li.add(cd);
		int size = li.size();
	//	Gson gsonli = new Gson();
	//	String gs = gsonli.toJson(li);
	//	session.setAttribute("cart", gs);
		session.setAttribute("count", size);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
//		mv.addObject("cart", gs);
		mv.addObject("cartitm",li);
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		System.out.println(session.getAttribute("cart"));
		return mv;

	}

	@RequestMapping(value = "/RemoveFromCart", method = RequestMethod.GET)
	public ModelAndView removeCart(@RequestParam("pid") int id, HttpSession session) {
		ArrayList<CartDetail> ld = (ArrayList<CartDetail>) session.getAttribute("mycart");
		ListIterator<CartDetail> lit = (ListIterator<CartDetail>) ld.listIterator();
		while (lit.hasNext()) {
			CartDetail d = lit.next();
			if (d.getPid() == id) {

				System.out.println(ld.indexOf(d));
				ld.remove(ld.indexOf(d));
				break;
			}
		}
		int size = ld.size();
		session.setAttribute("count", size);
		session.setAttribute("mycart", ld);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
	//	Gson gsonli = new Gson();
	//	String gs = gsonli.toJson(ld);
	//	mv.addObject("cart", gs);
		mv.addObject("cartitm",ld);
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(ld)));
		return mv;

	}

	@RequestMapping(value = "/OrderConfirmation", method = RequestMethod.GET)
	public ModelAndView orderConfirm(HttpSession session) {
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");

		Gson gsonli = new Gson();
		String gs = gsonli.toJson(li);
		session.setAttribute("cart", gs);
		ModelAndView mv = new ModelAndView("OrderConfirmation", "CartDetail", new CartDetail());
		mv.addObject("cart", gs);
		mv.addObject("useraddr", rdao.address((String) session.getAttribute("userid")));
		mv.addObject("info", rdao.display((String) session.getAttribute("userid")));
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		return mv;
	}

	@RequestMapping(value = "/AddToCartgoback", method = RequestMethod.GET)
	public ModelAndView cartgoback(HttpSession session) {

		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");

	//	Gson gsonli = new Gson();
	//	String gs = gsonli.toJson(li);
	//	session.setAttribute("cart", gs);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
//		mv.addObject("cart", gs);
		mv.addObject("cartitm",li);
		System.out.println(session.getAttribute("cart"));
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		return mv;

	}

	@RequestMapping(value = "/PaymentConfirmed", method = RequestMethod.GET)
	public String paymentconfirm(HttpSession session) {

		
		return "/PaymentConfirmed";

	}

	@RequestMapping(value = "/Thanku", method = RequestMethod.GET)
	public String Thanku(HttpSession session) {

		
		return "/ThankuPage";

	}

	@RequestMapping(value = "/GoToCart", method = RequestMethod.GET)
	public ModelAndView gotocartthrwlink(HttpSession session) {

		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
	//	Gson gsonli = new Gson();
	//	String gs = gsonli.toJson(li);
	//	session.setAttribute("cart", gs);
		ModelAndView mv = new ModelAndView("Cart", "CartDetail", new CartDetail());
		mv.addObject("cartitm", li);
		System.out.println(session.getAttribute("cart"));
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		return mv;

	}

	@RequestMapping(value = "/updateqty", method = RequestMethod.GET)
	public String updateqty(@RequestParam("qty")int qty,@RequestParam("pid")int pid,HttpSession session,Model m) 
	{

//		System.out.println("Quantity:"+qty);
//		System.out.println("Product ID:"+pid);
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
		ListIterator<CartDetail> lit = (ListIterator<CartDetail>) li.listIterator();
		while (lit.hasNext()) 
		{
			CartDetail d = lit.next();
			if (d.getPid() == pid) 
			{
				d.setQty(qty);
				lit.set(d);
				break;
			}
			
		}

	//	Gson gsonli = new Gson();
	//	String gs = gsonli.toJson(li);

	//	session.setAttribute("cart", gs);
	//	m.addAttribute("cart",gs);
		m.addAttribute("cartitm",li);
		session.setAttribute("grandtotal",String.valueOf(getGrandTotal(li)));
		// System.out.println(session.getAttribute("cart"));
		return "Cart";

	}

}
