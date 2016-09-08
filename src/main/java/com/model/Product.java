package com.model;

public class Product {

	private Integer productid;
private String name;
private String description;
private String supplierid;
private Integer price;
private String img;


public Product(Integer productid, String name, String description, String supplierid, Integer price, String img) {
	super();
	this.productid = productid;
	this.name = name;
	this.description = description;
	this.supplierid = supplierid;
	this.price = price;
	this.img = img;
}
public Integer getProductid() {
	return productid;
}
public void setProductid(Integer productid) {
	this.productid = productid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getSupplierid() {
	return supplierid;
}
public void setSupplierid(String supplierid) {
	this.supplierid = supplierid;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}

}



