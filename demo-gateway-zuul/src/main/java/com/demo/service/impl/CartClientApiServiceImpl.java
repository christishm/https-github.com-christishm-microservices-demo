package com.demo.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import com.demo.dao.CartClientService;
import com.demo.service.CartClientApiService;

@Service
public class CartClientApiServiceImpl implements CartClientApiService{
	
	public static Logger log = LoggerFactory.getLogger(CartClientApiServiceImpl.class);

	@Autowired
	CartClientService cartClientService;
	
	@Override
	public ResponseEntity<String> addToCart(String productId) {
		return cartClientService.addToCart(productId);
	}
	
	/* The Login details needs to be stored in Cache and fetched from Cache - Session Handling */
	public String getLogInIdForUser() {
	
		String userName = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(null != authentication) {
			Object principal = SecurityContextHolder.getContext()
					.getAuthentication().getPrincipal();
			if(principal instanceof UserDetails) {
				UserDetails userDetails = (UserDetails)principal;
				userName = userDetails.getUsername();
			}
			if(principal instanceof String) {
				userName=(String) principal;
			}
			
		}
	
		
		return "demo1";
	}

	@Override
	public String getLoggedInDemoUser() {
		return "demo1";
	}

}
