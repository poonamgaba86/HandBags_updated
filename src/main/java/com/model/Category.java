package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.SessionFactory;

@Entity
public class Category {
	
	
	@Id
	private int categoryid;
	@Column
	private String categorynm;
	@Column
	private String categorydesc;
	
	public Category()
	{}
	
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategorynm() {
		return categorynm;
	}
	public void setCategorynm(String categorynm) {
		this.categorynm = categorynm;
	}
	public String getCategorydesc() {
		return categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		this.categorydesc = categorydesc;
	}
	

}
