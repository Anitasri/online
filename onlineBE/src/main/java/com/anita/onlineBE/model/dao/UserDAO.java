package com.anita.onlineBE.model.dao;

import java.util.List;

import com.anita.onlineBE.model.dto.Address;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	User getByEmail(String email);

	// add an address
	boolean addAddress(Address address);
   
	
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
	// Alternative = runs so many queries
	//Address getBillingAddress(User user);
	//List<Address> listShippingAddresses(User user);
    
	// add an cart
	boolean updateCart(Cart cart);

}
