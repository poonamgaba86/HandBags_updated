package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.model.AdminProduct;
import com.model.Supplier;

@Repository
public class AdminProductDAO {
	@Autowired
	 SessionFactory sessionFactory;
	public void adProdSave(AdminProduct adprod)
	{
		Session session= sessionFactory.openSession();
		System.out.println("insert method called");
		session.beginTransaction();
		session.save(adprod);
		session.getTransaction().commit();
		session.close();
		
	}
	public String listAdProd()
	{
		
		Session se= sessionFactory.openSession();
		se.beginTransaction();
		List li=se.createQuery("from AdminProduct").list();
			Gson gson = new Gson();
	
		String jsonprodlist=gson.toJson(li);
		se.getTransaction().commit();
		se.close();
		return jsonprodlist ;
	}
	public void deleteAdProd(int apid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		AdminProduct adp=(AdminProduct)se.get(AdminProduct.class,apid);
		se.delete(adp);
		se.getTransaction().commit();
		se.close();
		
	}
	public void upAdProd(AdminProduct apd)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		 int apid=apd.getAproductId();
		AdminProduct adobj=(AdminProduct)se.get(AdminProduct.class,apid);
		adobj.setAdesciption(apd.getAdesciption());
		adobj.setAprodName(apd.getAprodName());
		adobj.setAprice(apd.getAprice());
		adobj.setAcategoryId(apd.getAcategoryId());
		adobj.setAstock(apd.getAstock());
		adobj.setAsupplierId(apd.getAsupplierId());
		

		 se.update(adobj);
		 se.getTransaction().commit();
	
		 se.close();
		
		
	}
	public AdminProduct DispRecord(int apid)
	{
		Session se=sessionFactory.openSession();
		 se.beginTransaction();
		AdminProduct adpd=(AdminProduct)se.get(AdminProduct.class,apid);
		return adpd;
		
	}
	public int sortId()
	{
		
		Session session=sessionFactory.openSession();

		Query query = session.createQuery("from AdminProduct order by aproductId DESC");
		query.setMaxResults(1);
		AdminProduct last = (AdminProduct) query.uniqueResult();
		int id=last.getAproductId();
		return id;
	}
	
	
	

}
