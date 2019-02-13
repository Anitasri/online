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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anita.onlineBE.model.dao.CategoryDAO;
import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dto.Category;
import com.anita.onlineBE.model.dto.Item;
import com.anita.onlineFE.util.FileUploadUtility;

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

		}

		return mv;

	}

	// Handling item submission
	@RequestMapping(value = "/items", method = RequestMethod.POST)
	public String handleItemSubmission(@Valid @ModelAttribute("item") Item mItem, BindingResult results, Model model,
			HttpServletRequest request) {

		// check for any errors
		if (results.hasErrors()) {

			model.addAttribute("userClickManageItems", true);
			model.addAttribute("title", "Manage Items");
			model.addAttribute("message", "Validation failed for item submission");
			return "page";
		}

		logger.info(mItem.toString());

		// create a new item record
		itemDAO.add(mItem);
		
		if(!mItem.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mItem.getFile(),mItem.getCode());
			
		}

		return "redirect:/manage/items?operation=item";

	}

	// returning categories for all the request
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.list();
	}

}
