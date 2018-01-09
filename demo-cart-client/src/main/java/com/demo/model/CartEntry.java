package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
Domain object representing CartEntry. This class will be used to persist and fetch CartEntry data from 
persistence layer using JPA implemention.
Design pattern used:Domain Model pattern.
*/

@Entity
public class CartEntry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long entryId;
	
	@NotNull
	private String productId;
	
	@Min(value=1)
	private int quantity;
	
	@NotNull
	private String userId;
	
	public CartEntry() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartEntry other = (CartEntry) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public CartEntry(String productId, int quantity, String userId) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.userId = userId;
	}

	public long getEntryId() {
		return entryId;
	}

	public String getProductId() {
		return productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getUserId() {
		return userId;
	}

	public void setEntryId(long entryId) {
		this.entryId = entryId;
	}

	@Override
	public String toString() {
		return "CartEntry [productId=" + productId + ", userId=" + userId + "]";
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}
