package com.demo.model;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	private long categoryId;
	
	private String categoryName;
	
	@OneToMany(cascade=CascadeType.ALL)
    private List<Product> products;
    
       
    public Category() {
    	super();
    }
    
    public Category(long categoryId,String categoryName,List<Product> products) {
    	this.categoryId=categoryId;
    	this.categoryName=categoryName;
    	this.products=products;
    }


	public long getCategoryId() {
		return categoryId;
	}


	public Optional<String> getCategoryName() {
		return Optional.ofNullable(categoryName);
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}



}
