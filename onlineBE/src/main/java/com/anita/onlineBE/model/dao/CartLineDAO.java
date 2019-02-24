package com.anita.onlineBE.model.dao;

import java.util.List;

import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.CartLine;
 

public interface CartLineDAO {

	//Basic CRUD operations
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndItem(int cartId, int itemId);		
	
	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);

	// update an cart
	boolean updateCart(Cart cart);
}
