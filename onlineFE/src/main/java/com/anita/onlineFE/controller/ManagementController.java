package com.anita.onlineFE.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")

public class ManagementController {
	
	@RequestMapping(value="/items", method=RequestMethod.GET)
	public ModelAndView showManageItems() {		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Manage Items");		
		mv.addObject("userClickManageItems",true);
		
		return mv;
		
	}
	
}
