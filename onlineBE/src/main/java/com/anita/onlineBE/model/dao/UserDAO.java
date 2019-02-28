package com.anita.onlineBE.model.dao;

import java.util.List;

import com.anita.onlineBE.model.dto.Address;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.User;

public interface UserDAO {

	// add an user
	User getByEmail(String email);
	User get(int id);

	boolean addUser(User user);

	// add an address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	
	// Alternative = runs so many queries
	//Address getBillingAddress(User user);
	//List<Address> listShippingAddresses(User user);

}
