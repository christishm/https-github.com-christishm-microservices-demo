package com.demo.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.demo.dao.GatewayClientService;
import com.demo.jpa.CartEntryRepository;
import com.demo.jpa.CartRepository;
import com.demo.model.CartEntry;
import com.demo.model.CartModel;
import com.demo.service.CartService;

/**
Service class used to support all the Cart operations.
The controller class in the MVC layer invokes the appropiate method in this class to execute business logic.
Design pattern used:Service Layer Pattern
Also @Autowired annotation uses Dependecy injection pattern to inject dependencies.
*/

@Service
public class CartServiceImpl implements CartService{
	
	public static Logger log = LoggerFactory.getLogger(CartServiceImpl.class);
	
	
	@Autowired
	private CartEntryRepository cartEntryRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private GatewayClientService gateWayClientService;

	@Override
	public boolean addToCart(String userId,String productId) {
		CartModel userCart = null;
		List<CartModel> cart = cartRepository.findByUserId(userId);
		if(!CollectionUtils.isEmpty(cart)) {
			userCart = cart.get(0);
		}
		
		if(null==userCart) {
			CartEntry newCartEntry = new CartEntry(productId,1,userId);//By default, Adding Item from Product details page, quantity is 1
			cartEntryRepository.save(newCartEntry);
			Set<CartEntry> cartEntries = new HashSet<CartEntry>();
			cartEntries.add(newCartEntry);
			userCart = new CartModel();
			userCart.setUserId(userId);
			userCart.setCartEntries(cartEntries);
			userCart.setCreatedDate(new Date());
			cartRepository.save(userCart);
			return true;
		}
		
		Set<CartEntry> cartEntries = userCart.getCartEntries();
		if(!CollectionUtils.isEmpty(cartEntries)) { //check for any existing cart entry with ProductId
		   List <CartEntry> existingCartEntries = cartEntries.stream().filter(entry->entry.getProductId().equals(productId)).collect(Collectors.toList());
		   if(!CollectionUtils.isEmpty(existingCartEntries)) { //In this case just increment quantity by one
			   CartEntry existingEntry = existingCartEntries.get(0);
			   int cartQuantity = existingEntry.getQuantity();
			   existingEntry.setQuantity(cartQuantity + 1);
			   userCart.setCartEntries(cartEntries);
			   cartRepository.save(userCart);
			   return true;
		   }
		}
		
		//creating a new CartEntry for new Product item and saving it to CartModel
		CartEntry newCartEntry = new CartEntry(productId,1,userId);
		cartEntryRepository.save(newCartEntry);
		Set<CartEntry> userCartEntries = userCart.getCartEntries();
		userCartEntries.add(newCartEntry);
		userCart.setCartEntries(userCartEntries);
		cartRepository.save(userCart);
		
		return true;
	}

	@Override
	public boolean updateCartEntry(String productId, int quantity) {
	    CartEntry entry =  searchEntries(productId);
	    if(null == entry) {
	    	log.error("Not Able to find CartItem for Product to Update:"+productId);
	    	return false;
	    }
		entry.setQuantity(quantity);
		cartEntryRepository.save(entry);
		return true;
	}

	@Override
	public boolean deleteCartEntry(String productId) {
		CartEntry entry =  searchEntries(productId);
		if(null == entry) {
		  log.error("Not Able to find CartItem for Product to Delete:"+productId);
		  return false;
		}
		String userId = entry.getUserId();
		List<CartModel> cart = cartRepository.findByUserId(userId);
		if(!CollectionUtils.isEmpty(cart)) {
			CartModel cartItem = cart.get(0);
			if(cartItem.getCartEntries().size()==1) {
				cartRepository.delete(cartItem);
			}
		}
		cartEntryRepository.delete(entry);
		return true;
	}

	@Override
	public List<CartEntry> getCartEntries(String userId) {
		return cartEntryRepository.findByUserId(userId);
	}
	
	private CartEntry searchEntries(String productId){
		CartEntry cartEntry = null;
		String userId = gateWayClientService.getLoggedInUserName();
		List<CartEntry> existingEntries = cartEntryRepository.findByUserId(userId);
		if(CollectionUtils.isEmpty(existingEntries)) {
			log.error("Not able to find Existing CartEntry for the UserId: "+userId);
			return null;
		}
		
		//Filter CartEntries for the Product
		List<CartEntry> productEntries =existingEntries.stream().filter(entry->entry.getProductId().equals(productId)).collect(Collectors.toList());
		if(CollectionUtils.isEmpty(productEntries)) {
			log.error("Not able to find Existing CartEntry for the ProductId: "+productId);
			return null;
		}
				
		cartEntry = productEntries.get(0);
		
		return cartEntry;
	}
	
	
}
