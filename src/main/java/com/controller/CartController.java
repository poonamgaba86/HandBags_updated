package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
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
import com.dao.OrderDetailsDAO;
import com.dao.RegisterUserDAO;
import com.google.gson.Gson;
import com.model.AdminProduct;
import com.model.CartDetail;
import com.model.OrderDetails;
import com.model.RegisterUser;

@Controller

public class CartController {
	@Autowired
	AdminProductDAO adProdDAO;
	@Autowired
	CartDAO cDAO;

	@Autowired
	RegisterUserDAO rdao;
	@Autowired
	OrderDetailsDAO oDAO;
	
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
		
		// to put the data in database also
	//	cDAO.addcart(cd);
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

	@RequestMapping(value = "/OrderPlaced", method = RequestMethod.GET)
	public ModelAndView orderplaced(HttpSession session) {
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
		
//			System.out.println(cd.getPid());
//			System.out.println(cd.getQty());
//			System.out.println(cd.getTotal());
//			System.out.println(cd.getPrice());
		
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

	@RequestMapping(value = "/OrderConfirmed", method = RequestMethod.GET)
	public ModelAndView OrderConfirmed(HttpSession session) 
	{
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
		 RegisterUser r=rdao.display((String) session.getAttribute("userid"));
	       
	       String email= r.getEmailId();
	       String phon= r.getMobileNo();
	       String addr=r.getAddress();
	       String user= r.getFirstName();
	       
	       String fullAddress= user +"\t"+addr +"\t"+phon;
	      
	       OrderDetails d= new OrderDetails();
			d.setPaymentMode("Debit Card");
	       d.setUserId(session.getAttribute("userid").toString());
	       d.setOrderDate(new Date());
	       d.setOrderStatus("processing");
	       
	       String f = session.getAttribute("grandtotal").toString();
	       
	       d.setGrandTotal(Integer.valueOf(f));
	       d.setAddress(fullAddress);
	       
	       oDAO.addOrderDetails(d);
	       System.out.print("Order saved");
	       int ordId=d.getOrderId();
	       session.setAttribute("oid", ordId);
	       for(CartDetail cd:li)
	       {
	    	   cd.setOrderID(ordId);
	    	  cDAO.addcart(cd);
	    	  System.out.print("Cart detail saved");
	    	   
	       }
	       
	       
	       
	       String data=oDAO.getOrderDetail(d.getOrderId());
			ModelAndView mv= new ModelAndView("AfterConfirmed");
			mv.addObject("data",data);


	//	ModelAndView mv = new ModelAndView("PaymentConfirmed","CartDetail",new CartDetail());
		
		return mv;

	}

	@RequestMapping(value = "/Thanku", method = RequestMethod.POST)
	public ModelAndView Thanku(HttpSession session,HttpServletRequest request)
	{
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
//		 RegisterUser r=rdao.display((String) session.getAttribute("userid"));
//       
//       String email= r.getEmailId();
//       String phon= r.getMobileNo();
//       String addr=r.getAddress();
//       String user= r.getFirstName();
//       
//       String fullAddress= user +"\t"+addr +"\t"+phon;
//      
//       OrderDetails d= new OrderDetails();
//		d.setPaymentMode("Debit Card");
//       d.setUserId(session.getAttribute("userid").toString());
//       d.setOrderDate(new Date());
//       d.setOrderStatus("processing");
//       
//       String f = session.getAttribute("grandtotal").toString();
//       
//       d.setGrandTotal(Integer.valueOf(f));
//       d.setAddress(fullAddress);
//       
//       oDAO.addOrderDetails(d);
//       System.out.print("Order saved");
//       int ordId=d.getOrderId();
//       for(CartDetail cd:li)
//       {
//    	   cd.setOrderID(ordId);
//    	  cDAO.addcart(cd);
//    	  System.out.print("Cart detail saved");
//    	   
//       }
//       
//       
//       
//       String data=oDAO.getOrderDetail(d.getOrderId());
			ModelAndView v= new ModelAndView("ThankuPage","OrderDetail",new OrderDetails());
//		v.addObject("data",data);
	//	System.out.println(data);
		return v ;
		

		
		

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


		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
		ListIterator<CartDetail> lit = (ListIterator<CartDetail>) li.listIterator();
		while (lit.hasNext()) 
		{
			CartDetail d = lit.next();
			if (d.getPid() == pid) 
			{
				d.setQty(qty);
				d.setTotal(d.getQty()*d.getPrice());
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

	@RequestMapping(value = "/Last", method = RequestMethod.GET)
	public ModelAndView lastpage(HttpSession session)
	{
		ArrayList<CartDetail> li = (ArrayList<CartDetail>) session.getAttribute("mycart");
	
      
      int oid=(Integer)session.getAttribute("oid");
		OrderDetails d= new OrderDetails();
      String data=oDAO.getOrderDetail(oid);
			ModelAndView v= new ModelAndView("Last","OrderDetail",new OrderDetails());
		v.addObject("data",data);

		return v ;
		
	}

}
