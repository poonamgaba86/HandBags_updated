package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.RegisterUser;
import com.model.UserCredential;

@Repository
public class UserCredentialDAO {
	@Autowired
	SessionFactory sessionFactory;
	public void saveUsercred(UserCredential uc)
	{
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(uc);
		session.getTransaction().commit();
		session.close();
	}

}
