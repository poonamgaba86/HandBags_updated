package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Category;
import com.model.Contact;

@Repository
public class ContactDAO {
	@Autowired
	 SessionFactory sessionFactory;
	public void saveContact(Contact con)
	{
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(con);
		session.getTransaction().commit();
		session.close();
		
	}

}
