package com.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.RegisterUser;

@Repository
public class RegisterUserDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public void saveUser(RegisterUser ru) 
	{
		Session session = sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(ru);
		session.getTransaction().commit();
		session.close();
	}

	public String address(String uname) {
		Session session = sessionFactory.openSession();
		Criteria cr = session.createCriteria(RegisterUser.class);
		String addr = ((RegisterUser) cr.add(Restrictions.like("userName", uname)).list().get(0)).getAddress();
		return addr;

	}

}
