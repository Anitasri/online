package com.anita.onlineFE.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anita.onlineFE.model.UserModel;
import com.anita.onlineBE.model.dao.CartLineDAO;
import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dao.UserDAO;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.CartLine;
import com.anita.onlineBE.model.dto.Item;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;

	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private HttpSession session;

	// returns the entire cartline
	public List<CartLine> getCartLines() {

		return cartLineDAO.list(this.getCart().getId());

	}

	// returns the user cart when logged in
	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public String updateCartLine(int cartLineId, int count) {
		// TODO Auto-generated method stub

		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		}

		else {
			Item item = cartLine.getItem();
			double oldTotal = cartLine.getTotal();

			if (item.getQuantity() <= count) {
				count = item.getQuantity();
			}

			// update the cart line
			cartLine.setItemCount(count);
			cartLine.setBuyingPrice(item.getUnitPrice());
			cartLine.setTotal(item.getUnitPrice() * count);
			cartLineDAO.update(cartLine);

			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			return "result=updated";
		}
	}

	public String deleteCartLine(int cartLineId) {

		// fetch cartline
		CartLine cartLine = cartLineDAO.get(cartLineId);

		if (cartLine == null) {
			return "result=error";
		} else {
			// update the cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			cartLineDAO.updateCart(cart);

			// remove the cartLine
			cartLineDAO.delete(cartLine);

			return "result=deleted";
		}
	}

}
