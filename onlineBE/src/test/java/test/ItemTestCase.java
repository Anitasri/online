package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.dao.ItemDAO;
import model.dto.Item;

public class ItemTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	
	private static ItemDAO itemDAO;
	
	
	@SuppressWarnings("unused")
	private Item item;
	
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("model");
		context.refresh();
		itemDAO = (ItemDAO)context.getBean("itemDAO");
	}
	
	/*@Test
	public void testCRUDItem() {
		
		// create operation
		item = new Item();
				
		item.setName("Mango Smoothie Bowl");
		item.setFoodType("Smoothie");
		item.setDescription("A base of cut mixed fruits is covered in a delicious whisk of hung curd, fresh cream and mango and topped with another helping of fruits and mango yogurt");
		item.setUnitPrice(91);
		item.setActive(true);
		item.setCategoryId(3);
		item.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new item!",
				true,itemDAO.add(item));		
		
		
		// reading and updating the category
		item =itemDAO.get(2);
		item.setName("Beijing Paneer Vegetable Stir-Fry");
		assertEquals("Something went wrong while updating the existing record!",
				true,itemDAO.update(item));		
				
		assertEquals("Something went wrong while deleting the existing record!",
				true,itemDAO.delete(item));		
		
		// list
		assertEquals("Something went wrong while fetching the list of items!",
				6,itemDAO.list().size());		
				
	}*/
		
	
	@Test
	public void testListActiveItems() {
		assertEquals("Something went wrong while fetching the list of items!",
				6,itemDAO.listActiveItems().size());				
	} 
	
	
	@Test
	public void testListActiveItemsByCategory() {
		assertEquals("Something went wrong while fetching the list of items!",
				2,itemDAO.listActiveItemsByCategory(3).size());
		assertEquals("Something went wrong while fetching the list of items!",
				2,itemDAO.listActiveItemsByCategory(1).size());
	} 
	
	@Test
	public void testGetLatestActiveItem() {
		assertEquals("Something went wrong while fetching the list of items!",
				3,itemDAO.getLatestActiveItems(3).size());
		
	} 
}
