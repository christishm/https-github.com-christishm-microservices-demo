package com.demo.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;


@Entity
public class CartModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cartId;
	
	@NotNull
	private String userId;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<CartEntry> cartEntries;
	
	@Override
	public String toString() {
		return "CartModel [cartId=" + cartId + ", userId=" + userId + ", cartEntries=" + cartEntries + "]";
	}

	public long getCartId() {
		return cartId;
	}

	public String getUserId() {
		return userId;
	}

	public Set<CartEntry> getCartEntries() {
		return cartEntries;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setCartEntries(Set<CartEntry> cartEntries) {
		this.cartEntries = cartEntries;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	private Date createdDate;
	
	public CartModel() {
		super();
	}

	public CartModel(String userId, Set<CartEntry> cartEntries, Date createdDate) {
		super();
		this.userId = userId;
		this.cartEntries = cartEntries;
		this.createdDate = createdDate;
	}

}
