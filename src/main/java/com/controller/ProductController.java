package com.controller;
import java.util.List;
import com.dao.productdao;
import com.google.gson.Gson;
import com.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController
{
	@Autowired
	productdao dao;
//	@RequestMapping("/ShowProduct")
//	public ModelAndView showproduct()
//	{
//		List<Product> li =dao.addproduct();
//		return new ModelAndView("ShowProduct","list",li);
//	}
	
	@RequestMapping("/ShowProduct")
    public String showproduct(Model m)
    {
                   Gson gson = new Gson();
                   List<Product> li =dao.addproduct();
         String jsonprdList = gson.toJson(li);
         m.addAttribute("proddt",jsonprdList);
                   return "ShowProduct";
    }


}
