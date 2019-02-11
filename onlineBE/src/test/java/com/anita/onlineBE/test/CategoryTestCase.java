package com.anita.onlineBE.test;



import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anita.onlineBE.model.dao.CategoryDAO;
import com.anita.onlineBE.model.dto.Category;

public class CategoryTestCase {

private static AnnotationConfigApplicationContext context;

private static CategoryDAO categoryDAO;

private Category category;

@BeforeClass
public static void init() {
	
	context =new AnnotationConfigApplicationContext();
	context.scan("model");
	context.refresh();
	
	categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
	
	
}

/* @Test
public void testAddCategory()
{
	
	category=new Category();
	 
	category.setName("Starters");
	category.setDescription("Its the best way to start an Indian meal");
	category.setImageURL("starter1.png");
	
	assertEquals("Successfully added the category inside the table",true,categoryDAO.add(category));

} */


 /* @Test
  public void testAddCategory()
  {
	  
	  category= categoryDAO.get(1);
	  
	  assertEquals("Successfully fetched from a single category from the table","Starters",category.getName());
  }

*/

/*@Test
public void testUpdateCategory()
{
	  
	  category= categoryDAO.get(1);
	  
	  assertEquals("Successfully update a single category inside the table",true,categoryDAO.update(category));
}*/


/*@Test
public void testDeleteCategory()
{
	  
	  category= categoryDAO.get(1);
	  
	  assertEquals("Successfully delete a single category inside the table",true,categoryDAO.delete(category));
}*/


/*@Test
public void testListCategory() {
				
	assertEquals("Successfully fetched the list of categories from the table!",0,categoryDAO.list().size());
	
	
}*/

@Test
public void testCRUDCategory() {
	
	// add operation
	category = new Category();
	
	category.setName("Starters");
	category.setDescription("Its the best way to start an Indian meal");
	category.setImageURL("starter1.png");
	
	assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
	
	
	category = new Category();
	
	category.setName("Main Course");
	category.setDescription("To fill your crying stomach");
	category.setImageURL("starter2.png");
	
	assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));

	
	// fetching and updating the category
	category = categoryDAO.get(2);
	
	category.setName("Main courses");
	
	assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
	
	
	// delete the category
	assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
	
	
	//fetching the list
	assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());		
			
	
}



}
