package com.anita.onlineFE.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anita.onlineBE.model.dao.CategoryDAO;
import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dto.Category;
import com.anita.onlineBE.model.dto.Item;
import com.anita.onlineFE.exception.ItemNotFoundException;


@Controller
public class PageController
{
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(value = {"/", "/home", "/index"})
	public ModelAndView index() 
	{		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		
		mv.addObject("userClickHome",true);
		return mv;
	}
	
	@RequestMapping(value = {"/about"})
	public ModelAndView about() 
	{		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact() 
	{		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	// Method to load all items
	
	@RequestMapping(value = "/show/all/items")
	public ModelAndView showAllItems() 
	{		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Items");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		
		mv.addObject("userClickAllItems",true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/items")
	public ModelAndView showCategoryItems(@PathVariable("id") int id) 
	{		
		ModelAndView mv = new ModelAndView("page");		
        
		//categoryDAO to fetch a category
		
		Category category=null;
		
		category= categoryDAO.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing single category object
		
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryItems",true);
		
		return mv;
	}

	//Viewing a single item
	
	
	@RequestMapping(value = "/show/{id}/item") 
	public ModelAndView showSingleItem(@PathVariable int id)  throws ItemNotFoundException {
			
		
		ModelAndView mv = new ModelAndView("page");
		
		Item item = itemDAO.get(id);
		
		if(item == null) throw new ItemNotFoundException();
		
		// update the view count
		item.setViews(item.getViews() + 1);
		itemDAO.update(item);
		
		//---------------------------
		
		mv.addObject("title", item.getName());
		mv.addObject("item", item);
		
		mv.addObject("userClickShowItem", true);
		
		
		return mv;
		
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error) {
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Non-Accessible page");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}	
	
	//having similar mapping for flow id
	@RequestMapping(value = {"/register"})
	public ModelAndView register() 
	{		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Register");
		return mv;
	}
	
}	
