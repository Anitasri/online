package com.anita.onlineFE.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anita.onlineFE.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {

	
	private final static Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name = "result", required = false) String result) {

		ModelAndView mv = new ModelAndView("page");
		
		if(result!=null) {
			switch(result) {
				
				case "updated":
					mv.addObject("message", "CartLine has been updated successfully!");					
					break;
				case "added":
					mv.addObject("message", "CartLine has been added successfully!");					
					break;
				case "maximum":
					mv.addObject("message", "CartLine has reached to maximum count!");					
					break;
				case "unavailable":
					mv.addObject("message", "Item unavailable!");					
					break;
				case "deleted":
					mv.addObject("message", "CartLine has been removed successfully!");					
					break;
					
				case "error":
					mv.addObject("message", "Something went wrong!");					
					break;
				
			}
		}
		
		mv.addObject("title", "Shopping Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());
		return mv;
	}

	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId, @RequestParam int count) {
		String response = cartService.manageCartLine(cartLineId, count);		
		return "redirect:/cart/show?"+response;		
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?"+response;
	}
	
	@RequestMapping("/add/{itemId}/item")
	public String addCart(@PathVariable int itemId) {
		String response = cartService.addCartLine(itemId);
		return "redirect:/cart/show?"+response;
	}
}