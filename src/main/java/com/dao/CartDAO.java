package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.model.AdminProduct;
import com.model.CartDetail;

@Repository
public class CartDAO {
	@Autowired
	 SessionFactory sessionFactory;
	public void addcart(CartDetail cd)
	{
		Session session= sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(cd);
		session.getTransaction().commit();
	//	Gson gs= new Gson();
	//	String cartDe=gs.toJson(cd);
		session.close();

	}
	public void remcart(int cartid)
	{
//		Session session= sessionFactory.openSession();
//		
//		session.beginTransaction();
//		
//		CartDetail cd=(CartDetail)session.get(CartDetail.class,cartid);
//		session.delete(cd);
//		session.getTransaction().commit();
//		session.close();
//	
	}
//	public String showcart(CartDetail cd)
//	{
//		Session session= sessionFactory.openSession();
//		
////		session.beginTransaction();
////		session.save(cd);
////		session.getTransaction().commit();
////		Gson gs= new Gson();
////		String cartDe=gs.toJson(cd);
//		session.close();
//		return cartDe;
//	
//	}
	

}
