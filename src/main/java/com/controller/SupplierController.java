package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AddCategoryDAO;
import com.dao.SupplierDAO;
import com.model.Category;
import com.model.Supplier;
@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supDAO;
	
	
	
	@RequestMapping(value="/SupplierView",method = RequestMethod.GET)
	public ModelAndView showSupplier() 
	{
		String supjsonlist=supDAO.listSupplier();
		ModelAndView mv = new ModelAndView("SupplierView","Supplier",new Supplier());
		int id=supDAO.sortId();
		mv.addObject("data",supjsonlist);
		mv.addObject("check", true);
		mv.addObject("supid",id);
		return mv;
	}
	@RequestMapping(value="/SupplierView",method = RequestMethod.POST)
	public ModelAndView addSupplier(Supplier sup) 
	{
		supDAO.saveSupplier(sup);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView mv = new ModelAndView("SupplierView","Supplier",new Supplier());
		mv.addObject("data",supjsonlist);
		mv.addObject("check",true);
		int id=supDAO.sortId();
		mv.addObject("supid",id);
		return mv;
	}
	@RequestMapping(value="/delsupplier",method = RequestMethod.GET)
	public ModelAndView delSupplier(@RequestParam("suppId")int sid) 
	{
		
		
		supDAO.deleteSupplier(sid);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView m = new ModelAndView("SupplierView","Supplier",new Supplier());
		m.addObject("check",true);
		m.addObject("data",supjsonlist);
		int id=supDAO.sortId();
		m.addObject("supid",id);
		return m;
	}
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.GET)
	public ModelAndView Updatesupp(@RequestParam("suppId")int sid)
	{
		
		
		Supplier sup =supDAO.DispRecord(sid);
		ModelAndView m = new ModelAndView("SupplierView","Supplier",sup);
		m.addObject("check",false);
		return m;
		
	}

	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public ModelAndView updatesupp(Supplier s)
	{

		supDAO.UpRecord(s);
		String supjsonlist=supDAO.listSupplier();
		ModelAndView m = new ModelAndView("SupplierView","Supplier",new Supplier());
		m.addObject("check",true);
		m.addObject("data",supjsonlist);
		int id=supDAO.sortId();
		m.addObject("supid",id);
		return m;
		
	}

}
