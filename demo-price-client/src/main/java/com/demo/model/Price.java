package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Price {
	
	@Id
	private long priceId;
	
	private String productId;
	
	private double priceInfo;
	
	public Price() {
		super();
	}
	
	
	public Price(long priceId, String productId, double priceInfo) {
		super();
		this.priceId = priceId;
		this.productId = productId;
		this.priceInfo = priceInfo;
	}



	@Override
	public String toString() {
		return "Price [priceId=" + priceId + ", productId=" + productId + ", priceInfo=" + priceInfo + "]";
	}



	public long getPriceId() {
		return priceId;
	}

	
	public double getPriceInfo() {
		return priceInfo;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public void setPriceInfo(double priceInfo) {
		this.priceInfo = priceInfo;
	}

}
