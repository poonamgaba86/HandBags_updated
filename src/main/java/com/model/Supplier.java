package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue
	private int suppId;
	@Column
	private String suppName;
	@Column
	private String suppAdd;
	@Column
	private String contactNo;
	public Supplier()
	{
		
	}
	public int getSuppId() {
		return suppId;
	}
	public void setSuppId(int suppId) {
		this.suppId = suppId;
	}
	public String getSuppName() {
		return suppName;
	}
	public void setSuppName(String suppName) {
		this.suppName = suppName;
	}
	public String getSuppAdd() {
		return suppAdd;
	}
	public void setSuppAdd(String suppAdd) {
		this.suppAdd = suppAdd;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	

}
