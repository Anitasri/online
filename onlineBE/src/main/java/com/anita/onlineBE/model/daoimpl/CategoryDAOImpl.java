package com.anita.onlineBE.model.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anita.onlineBE.model.dao.CategoryDAO;
import com.anita.onlineBE.model.dto.Category;



@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	 
	
	
		@SuppressWarnings("unchecked")
		@Override
		public List<Category> list() {
		
			String selectActiveCategory = "FROM Category WHERE active = :active";
			
			@SuppressWarnings("rawtypes")
			Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
					
			query.setParameter("active", true);
							
			return query.getResultList();
			
		
	}

		//Getting single category based on id

		@Override
		public Category get(int id) {
        // TODO Auto-generated method stub
		
			
			
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}



		@Override
       
        
		public boolean add(Category category) {

			try {
				// add the category to the database table
				
				sessionFactory.getCurrentSession().persist(category);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}

		}


       //update a single category
		@Override
		public boolean update(Category category) {
			try {
				// add the category to the database table
				
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}



		@Override
		public boolean delete(Category category) {
			
			category.setActive(false);
			
			try {
				// add the category to the database table
				
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (Exception ex) {
				ex.printStackTrace();
				return false;
			}
		}


}
