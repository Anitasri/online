package com.anita.onlineFE.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.anita.onlineBE.model.dao.CategoryDAO;
import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dto.Category;
import com.anita.onlineBE.model.dto.Item;
import com.anita.onlineFE.util.FileUploadUtility;
import com.anita.onlineFE.validator.ItemValidator;

@Controller
@RequestMapping("/manage")

public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ItemDAO itemDAO;

	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public ModelAndView showManageItems(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Items");
		mv.addObject("userClickManageItems", true);
		Item nItem = new Item();
		// set few of the fields
		nItem.setSupplierId(1);
		nItem.setActive(true);
		mv.addObject("item", nItem);
		if (operation != null) {
			if (operation.equals("item")) {
				mv.addObject("message", "Item submitted successfully!");
			}
			else if(operation.equals("category")) {
				mv.addObject("message", "Category submitted successfully!");	
			}
		}

		return mv;

	}
	
	@RequestMapping(value="/{id}/item",method=RequestMethod.GET)
	public ModelAndView showEditItem(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Items");
		mv.addObject("userClickManageItems", true);
        //fetch item from the database
		Item nItem = itemDAO.get(id);
		//set the item fetch from the database
		mv.addObject("item", nItem);
		return mv;

	}
	

	// Handling item submission
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public String handleItemSubmission(@Valid @ModelAttribute("item") Item mItem, BindingResult results, Model model,
			HttpServletRequest request) {

		//handling image validation for new item
		if(mItem.getId()==0) {
		new ItemValidator().validate(mItem,results);
		} 
		
		else {
		if(!mItem.getFile().getOriginalFilename().equals("")) {
		
			new ItemValidator().validate(mItem,results);	
		       }
		    
		}
		// check for any errors
		if (results.hasErrors()) {

			model.addAttribute("userClickManageItems", true);
			model.addAttribute("title", "Manage Items");
			model.addAttribute("message", "Validation failed for item submission");
			return "page";
		}

		logger.info(mItem.toString());
		
		if(mItem.getId()==0) {	
			// create a new item if id is zero
		itemDAO.add(mItem); 
		}
		
		else {
			//update the item if id is not zero
			itemDAO.update(mItem);	
		}
		
		if(!mItem.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mItem.getFile(),mItem.getCode());
			
		}

		return "redirect:/manage/items?operation=item";

	}
	
	@RequestMapping(value = "/item/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleItemActivation(@PathVariable int id) {		
		
		//is going to fetch the item from the database
		Item item = itemDAO.get(id);
		boolean isActive = item.isActive();
		
		//activating and deactivating based on the value of active field 
		item.setActive(!item.isActive());
		
		//updating the item
		itemDAO.update(item);		
		return (isActive)? 
				"Item Deactivated Successfully with the id "+item.getId(): 
			    "Item Activated Successfully with the id "+item.getId();
	}
	
	//to handle new category submission
	@RequestMapping(value = "/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {					
		categoryDAO.add(category);		
		return "redirect:/manage/items?operation=category";
	}
	
	
	
	// returning categories for all the request
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}

	//For adding a new category
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	
	
	
}
