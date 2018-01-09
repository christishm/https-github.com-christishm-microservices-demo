package com.demo.service;

import org.springframework.http.ResponseEntity;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public interface CartClientApiService {
	
	ResponseEntity<String> addToCart(String productId);
	
	/**
	 Using Circuit breaker design pattern to mitigate cascading failures when service is not available.
	 'fallbackMethod' attribute specifies method which will be called when client service is not available.
	*/
	@HystrixCommand(fallbackMethod="getLoggedInDemoUser")
	String getLogInIdForUser();
	
	String getLoggedInDemoUser();
	
	
}
