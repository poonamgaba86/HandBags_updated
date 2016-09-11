package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AddCategoryDAO;
import com.dao.AdminProductDAO;
import com.dao.SupplierDAO;
import com.model.AdminProduct;
import com.model.Category;
import com.model.Supplier;
@Controller
public class AdminProductController {
	
	@Autowired
	AddCategoryDAO catDAO;
	@Autowired
	SupplierDAO supDAO;
	@Autowired
	AdminProductDAO adProdDAO;
	
	@RequestMapping(value="/AdminProducts",method = RequestMethod.GET)
	public ModelAndView showAdminProduct() 
	{
		
		ModelAndView mv = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		String catjsonlist=catDAO.ListCategory();
		mv.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		mv.addObject("data2",supjsonlist);
		String adprod=adProdDAO.listAdProd();
		mv.addObject("data3",adprod);
		int id=adProdDAO.sortId();
		mv.addObject("adpid",id);
		mv.addObject("check",true);
		return mv;
	}
	@RequestMapping(value="/AdminProducts",method=RequestMethod.POST)
	public ModelAndView addAdminProduct(AdminProduct aprod)
	{
		adProdDAO.adProdSave(aprod); 
		String adprd=adProdDAO.listAdProd();
		ModelAndView mv = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		mv.addObject("data3",adprd);
		String catjsonlist=catDAO.ListCategory();
		mv.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		mv.addObject("data2",supjsonlist);
		mv.addObject("check",true);
		int id=adProdDAO.sortId();
		mv.addObject("adpid",id);
		return mv;
		
	}
	@RequestMapping(value="/deladprod",method = RequestMethod.GET)
	public ModelAndView delAdProd(@RequestParam("adpid")int adpid) 
	{
		
		adProdDAO.deleteAdProd(adpid);
		
		String adpjson=adProdDAO.listAdProd();
			ModelAndView m = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		m.addObject("check",true);
		m.addObject("data3",adpjson);
		int id=adProdDAO.sortId();
		m.addObject("adpid",id);
		String catjsonlist=catDAO.ListCategory();
		m.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		m.addObject("data2",supjsonlist);
		return m;
	}
	@RequestMapping(value="/UpdateAdmprod",method=RequestMethod.GET)
	public ModelAndView updateProd(@RequestParam("adpid")int pid)
	{
		
		
		AdminProduct ad =adProdDAO.DispRecord(pid);
		ModelAndView m = new ModelAndView("AdminProductPage","AdminProduct",ad);
		m.addObject("check",false);
		String catjsonlist=catDAO.ListCategory();
		m.addObject("data",catjsonlist);
		String supjsonlist=supDAO.listSupplier();
		m.addObject("data2",supjsonlist);
		return m;
		
	}

	@RequestMapping(value="/UpdateAdmprod",method=RequestMethod.POST)
	public ModelAndView updateProd(AdminProduct ap)
	{

		adProdDAO.upAdProd(ap);
		String apdjsonlist=adProdDAO.listAdProd();
		ModelAndView m = new ModelAndView("AdminProductPage","AdminProduct",new AdminProduct());
		m.addObject("check",true);
		m.addObject("data3",apdjsonlist);
		int id=adProdDAO.sortId();
		m.addObject("adpid",id);
		return m;
		
	}

}
