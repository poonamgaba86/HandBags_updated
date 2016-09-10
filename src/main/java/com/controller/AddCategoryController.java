package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.AddCategoryDAO;
import com.model.Category;
@Controller
public class AddCategoryController 
{
	@Autowired
	AddCategoryDAO catDAO;
	
	@RequestMapping(value="/AddCategory",method = RequestMethod.GET)
	public ModelAndView showcategory() 
	{
		String catjsonlist=catDAO.ListCategory();
		
		ModelAndView mv= new ModelAndView("AddCategory","Category",new Category());
		//System.out.println("welcome");
		mv.addObject("check",true);
		mv.addObject("data",catjsonlist);
		
		
		return mv;
	}
@RequestMapping(value="/AddCategory",method=RequestMethod.POST)
public ModelAndView addcategory(Category cat)
{
	catDAO.saveCategory(cat);
	String catjsonlist=catDAO.ListCategory();
	ModelAndView m = new ModelAndView("AddCategory","Category",new Category());
	
	System.out.println("welcome");
	
	m.addObject("data",catjsonlist);
	m.addObject("check",true);
	return m;
}
@RequestMapping(value="/DeleteCategory",method=RequestMethod.GET)
public ModelAndView delcategory(@RequestParam("categoryid")int cid)
{
	
	System.out.println(cid);
	catDAO.DelCategory(cid);
	String catjsonlist=catDAO.ListCategory();
	ModelAndView m = new ModelAndView("AddCategory","Category",new Category());
	m.addObject("check",true);
	m.addObject("data",catjsonlist);
	return m;
	
}
@RequestMapping(value="/UpdateCategory",method=RequestMethod.GET)
public ModelAndView Updatecategory(@RequestParam("categoryid")int cid)
{
	
	System.out.println(cid);
	Category cat1=catDAO.DispRecord(cid);
	ModelAndView m = new ModelAndView("AddCategory","Category",cat1);
	m.addObject("check",false);
	return m;
	
}

@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
public ModelAndView updatecategory(Category cate)
{
//	Category cat=catDAO.DispRecord(cid);
//	System.out.println(cid);
	catDAO.UpRecord(cate);
	String catjsonlist=catDAO.ListCategory();
	ModelAndView m = new ModelAndView("AddCategory","Category",new Category());
	m.addObject("check",true);
	m.addObject("data",catjsonlist);
	return m;
	
}

}
