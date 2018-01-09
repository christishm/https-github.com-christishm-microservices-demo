package com.demo.service;

import java.util.List;

import com.demo.model.CartEntry;

public interface CartService {
	
	boolean addToCart(String userId,String productId);
	
	boolean updateCartEntry(String productId,int quantity);
	
	boolean deleteCartEntry(String productId);
	
	List<CartEntry> getCartEntries(String userId);

}
