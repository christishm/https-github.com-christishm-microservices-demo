package com.demo.service;

import java.util.List;

import com.demo.model.CartEntry;

/**
Interface where all the Cart service methods are defined which will be implemented by a implementation class.
Coding to Interface design pattern is used.
*/
public interface CartService {
	
	boolean addToCart(String userId,String productId);
	
	boolean updateCartEntry(String productId,int quantity);
	
	boolean deleteCartEntry(String productId);
	
	List<CartEntry> getCartEntries(String userId);

}
