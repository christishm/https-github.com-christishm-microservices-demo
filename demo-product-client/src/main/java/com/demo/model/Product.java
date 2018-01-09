package com.demo.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
   
	@Id
	private long productId;
	
	private String name;
	
	private String desc;
	
	public Product() {
		super();
	}
	
	public Product(long productId,String name,String desc) {
		this.productId=productId;
		this.name=name;
		this.desc=desc;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + "]";
	}

	public long getProductId() {
		return productId;
	}

	public String getName() {
		return name;
	}

	public Optional<String> getDesc() {
		return Optional.ofNullable(desc);
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
