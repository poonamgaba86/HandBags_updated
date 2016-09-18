package com.dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.model.AdminProduct;
import com.model.Category;
import java.util.*;


import javax.transaction.Transaction;

@Repository
public class AddCategoryDAO {
	@Autowired
	 SessionFactory sessionFactory;
	public void saveCategory(Category category)
	{
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(category);
		session.getTransaction().commit();
		session.close();
		
	}
	public String ListCategory()
	{
		
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		List li=se.createQuery("from Category").list();
			Gson gson = new Gson();
	
		String jsoncatlist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		return jsoncatlist ;
	}
	public void DelCategory(int cid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		Category cat=(Category)se.get(Category.class,cid);
		se.delete(cat);
		se.getTransaction().commit();
		se.close();
		
	}
	public Category DispRecord(int cid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		Category cat=(Category)se.get(Category.class,cid);
		se.getTransaction().commit();
		se.close();
		
		return cat;
		
	}
	public void UpRecord(Category catobj)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 int cid=catobj.getCategoryid();
		 Category cat=(Category)se.get(Category.class,cid);
		 cat.setCategorynm(catobj.getCategorynm());
		 cat.setCategorydesc(catobj.getCategorydesc());
		 se.update(cat);
		 se.getTransaction().commit();
	
		 se.close();
		
		
	}
	public int sortcatId()
	{
		
		Session session=sessionFactory.openSession();

		Query query = session.createQuery("from Category order by categoryid DESC");
		query.setMaxResults(1);
	Category last = (Category) query.uniqueResult();
		int id=last.getCategoryid();
		return id;
	}


}
