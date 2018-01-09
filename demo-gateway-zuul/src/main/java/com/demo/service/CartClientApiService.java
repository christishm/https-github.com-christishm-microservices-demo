package com.demo.service;

import org.springframework.http.ResponseEntity;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface CartClientApiService {
	
	ResponseEntity<String> addToCart(String productId);
	
	@HystrixCommand(fallbackMethod="getLoggedInDemoUser")
	String getLogInIdForUser();
	
	String getLoggedInDemoUser();
	
	
}
