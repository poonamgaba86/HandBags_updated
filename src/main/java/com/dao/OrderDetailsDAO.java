package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.CartDetail;
import com.model.OrderDetails;

@Repository
public class OrderDetailsDAO {
	
	@Autowired
	 SessionFactory sessionFactory;
	public void addOrderDetails(OrderDetails od)
	{
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(od);
		session.getTransaction().commit();

		session.close();

	}

	
}
