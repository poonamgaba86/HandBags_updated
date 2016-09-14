package com.controller;
import java.util.List;

import com.dao.AdminProductDAO;
import com.dao.productdao;
import com.google.gson.Gson;
import com.model.AdminProduct;
import com.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController
{
	@Autowired
	productdao dao;
	@Autowired
	AdminProductDAO aDAO;
//	@RequestMapping("/ShowProduct")
//	public ModelAndView showproduct()
//	{
//		List<Product> li =dao.addproduct();
//		return new ModelAndView("ShowProduct","list",li);
//	}
	
//	@RequestMapping("/ShowProduct")
//    public String showproduct(Model m)
//    {
//                   Gson gson = new Gson();
//                   List<Product> li =dao.addproduct();
//         String jsonprdList = gson.toJson(li);
//         m.addAttribute("proddt",jsonprdList);
//                   return "ShowProduct";
//    }

	@RequestMapping("/ShowProduct")
  public ModelAndView showproduct()
  {
            String jsondata= aDAO.listAdProd();
            ModelAndView mv = new ModelAndView("ShowProduct","AdminProduct",new AdminProduct());
            mv.addObject("dat",jsondata);
            return mv;
            
  }
	@RequestMapping("/ShwPrdtInDetail")
	  public ModelAndView showProductInDetail(@RequestParam("adpid")int pid)
	  {
				System.out.println(pid);
				AdminProduct apd=aDAO.DispRecord(pid);
				Gson gsonlist= new Gson();
				String rec=gsonlist.toJson(apd);
				 ModelAndView mv = new ModelAndView("ShwPrdtInDetail","AdminProduct",new AdminProduct());
	              mv.addObject("detail",rec);
	            return mv;
	            
	  }
	
	

}
