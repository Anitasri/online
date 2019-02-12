package com.anita.onlineFE.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anita.onlineBE.model.dao.CategoryDAO;
import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dto.Category;
import com.anita.onlineBE.model.dto.Item;

@Controller
@RequestMapping("/manage")

public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ItemDAO itemDAO;
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public ModelAndView showManageItems(@RequestParam(name="operation",required=false) String operation )  {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Items");
		mv.addObject("userClickManageItems", true);

		Item nItem = new Item();

		//set few of the fields
		nItem.setSupplierId(1);
		nItem.setActive(true);

		mv.addObject("item", nItem);

		if(operation != null) {
			if(operation.equals("item")){
				mv.addObject("message", "Item submitted successfully!");
			}	
			
		}
		
		return mv;

	}

	//Handling item submission
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public String handleItemSubmission(@ModelAttribute("item") Item mItem) {
		
		logger.info(mItem.toString());
		
		//create a new item record
		itemDAO.add(mItem);
		
		return "redirect:/manage/items?operation=item";
		
	}
	
	
	
	
	//returning categories for all the request
	@ModelAttribute("categories") 
	public List<Category> getCategories() {
		return categoryDAO.list();
	}



}
