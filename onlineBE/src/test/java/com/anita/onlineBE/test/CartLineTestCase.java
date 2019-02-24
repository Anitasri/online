package com.anita.onlineBE.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.anita.onlineBE.model.dao.CartLineDAO;
import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dao.UserDAO;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.CartLine;
import com.anita.onlineBE.model.dto.Item;
import com.anita.onlineBE.model.dto.User;

public class CartLineTestCase {

	

	private static AnnotationConfigApplicationContext context;
	
	
	private static CartLineDAO cartLineDAO;
	private static ItemDAO itemDAO;
	private static UserDAO userDAO;
	
	
	private CartLine cartLine = null;
	private User user=null;
	private Cart cart=null;
	private Item item=null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.anita.onlineBE");
		context.refresh();
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
		itemDAO = (ItemDAO)context.getBean("itemDAO");
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	

	@Test
	public void testAddCartLine() {
		
		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("shka@gmail.com");		
		Cart cart = user.getCart();
		
		// fetch the item
		Item item = itemDAO.get(1);
		
		// Create a new CartLine
		cartLine = new CartLine();
		cartLine.setBuyingPrice(item.getUnitPrice());
		cartLine.setItemCount(cartLine.getItemCount()+1);
		cartLine.setTotal(item.getUnitPrice()*cartLine.getItemCount());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setItem(item);
		
		assertEquals("Failed to add the CartLine!",true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		
		assertEquals("Failed to update the cart!",true, cartLineDAO.updateCart(cart));
		
	}
	
	
	
	/*@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userDAO.getByEmail("absr@gmail.com");		
		Cart cart = user.getCart();
				
		cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), 2);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
				
		double oldTotal = cartLine.getTotal();
				
		cartLine.setTotal(cartLine.getProduct().getUnitPrice() * cartLine.getProductCount());
		
		cart.setGrandTotal(cart.getGrandTotal() + (cartLine.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartLineDAO.update(cartLine));	

		
	}
	
	*/
	
}
