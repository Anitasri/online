package com.anita.onlineBE.model.dao;

import java.util.List;

import com.anita.onlineBE.model.dto.Address;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);

	// add an address
	boolean addAddress(Address address);

	// add an cart
	boolean addCart(Cart cart);

}
