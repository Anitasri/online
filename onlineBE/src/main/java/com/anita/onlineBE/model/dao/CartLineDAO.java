package com.anita.onlineBE.model.dao;

import java.util.List;

import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.CartLine;
import com.anita.onlineBE.model.dto.OrderDetail;

public interface CartLineDAO {

	// Basic CRUD operations
	public List<CartLine> list(int cartId);

	public CartLine get(int id);

	public boolean add(CartLine cartLine);

	public boolean update(CartLine cartLine);

	public boolean delete(CartLine cartLine);

	// fetch the CartLine based on cartId and productId
	public CartLine getByCartAndItem(int cartId, int itemId);

	// update an cart
	boolean updateCart(Cart cart);

	// list of available cartLine
	public List<CartLine> listAvailable(int cartId);

	// adding order details
	boolean addOrderDetail(OrderDetail orderDetail);
}
