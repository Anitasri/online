package com.anita.onlineBE.model.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anita.onlineBE.model.dao.UserDAO;
import com.anita.onlineBE.model.dto.Address;
import com.anita.onlineBE.model.dto.Cart;
import com.anita.onlineBE.model.dto.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			
			sessionFactory.getCurrentSession().persist(user);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {			
		
			sessionFactory.getCurrentSession().persist(address);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		try {			
		
			sessionFactory.getCurrentSession().persist(cart);			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

}
