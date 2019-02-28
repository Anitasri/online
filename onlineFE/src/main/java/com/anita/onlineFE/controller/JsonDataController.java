package com.anita.onlineFE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dto.Item;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping("admin/all/items")
	@ResponseBody
	public List<Item> getAllItemsForAdmin() {
		return itemDAO.list();		
	}
	
	@RequestMapping("/all/items")
	@ResponseBody
	public List<Item> getAllItems() {
		return itemDAO.listActiveItems();
				
	}
	
	@RequestMapping("/category/{id}/items")
	@ResponseBody
	public List<Item> getItemsByCategory(@PathVariable int id) {
		return itemDAO.listActiveItemsByCategory(id);			
	}
	
	@RequestMapping("/mv/items")
	@ResponseBody
	public List<Item> getMostViewedItems() {		
		return itemDAO.getItemsByParam("views", 5);				
	}
		
	@RequestMapping("/mp/items")
	@ResponseBody
	public List<Item> getMostPurchasedItems() {		
		return itemDAO.getItemsByParam("purchases", 5);				
	}
		
}