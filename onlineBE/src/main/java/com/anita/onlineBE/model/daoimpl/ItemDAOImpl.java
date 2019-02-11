package com.anita.onlineBE.model.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anita.onlineBE.model.dao.ItemDAO;
import com.anita.onlineBE.model.dto.Item;

@Repository("itemDAO")
@Transactional

public class ItemDAOImpl implements ItemDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE product
	 * */
	
	@Override
	public Item get(int itemId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Item.class,Integer.valueOf(itemId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST of Items
	 * */
	
	@Override
	public List<Item> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Item" , Item.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public boolean add(Item item) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(item);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Item item) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(item);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Item item) {
		try {
			
			item.setActive(false);
			// call the update method
			return this.update(item);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Item> listActiveItems() {
		String selectActiveItems = "FROM Item WHERE active = :active";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveItems, Item.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Item> listActiveItemsByCategory(int categoryId) {
		String selectActiveItemsByCategory = "FROM Item WHERE active = :active AND categoryId = :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveItemsByCategory, Item.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	@Override
	public List<Item> getLatestActiveItems(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Item WHERE active = :active ORDER BY id", Item.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}

	@Override
	public List<Item> getItemsByParam(String param, int count) {
		
		String query = "FROM Item WHERE active = true ORDER BY " + param + " DESC";
		
		return sessionFactory
					.getCurrentSession()
					.createQuery(query,Item.class)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
					
		
	}

	
}
