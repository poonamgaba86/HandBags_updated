package com.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import com.model.Product;
@Repository
public class productdao
{
	
		List<Product> prod;
			public List<Product> addproduct()
			{
					prod = new ArrayList<Product>();
					Product p1= new Product(1,"p1","Lxe pruna Tomato","s01",1750,"bag5");
					Product p2= new Product(2,"p2","L Amaze Emily L Blue (Blue) L","s02",1750,"bag6");
					Product p3= new Product(3,"p3","Gw Tyko Times Brown (Brown) S","s03",750,"bag3");
					Product p4= new Product(4,"p4","Lw Macaroon N Seafoam Green (Green) Xl","s04",2750,"icon");
					Product p5= new Product(5,"p5","L Itsy N Seafoam Green (Green) M","s05",4750,"bag1");
					Product p6= new Product(6,"p6","Lxe pruna Tomato","s06",3750,"bag2");
					Product p7= new Product(7,"p7","Lxe pruna Tomato","s07",6750,"bag3");
					prod.add(p1);
					prod.add(p2);
					prod.add(p3);
					prod.add(p4);
					prod.add(p5);
					prod.add(p6);
					prod.add(p7);
					return prod;
					
					
			}
			}
