package model.dao;

import java.util.List;

import model.dto.Item;

public interface ItemDAO {
	Item get(int itemId);
	List<Item> list();	
	boolean add(Item item);
	boolean update(Item item);
	boolean delete(Item item);

	List<Item> getItemsByParam(String param, int count);	
	
	
	// business methods
	List<Item> listActiveItems();	
	List<Item> listActiveItemsByCategory(int categoryId);
	List<Item> getLatestActiveItems(int count);
	

}
