package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


import com.demo.service.CartClientApiService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class GateWayController {
	
	public static Logger log = LoggerFactory.getLogger(GateWayController.class);
	@Autowired
	CartClientApiService cartClientApiService;
	
	
	@GetMapping("/")
	public String onLogin(){
		String userId = cartClientApiService.getLogInIdForUser();
		log.info("LoggedIn UserId :"+userId);
		return "product";
	}
	
	@GetMapping("/cart/{productId}")
    public String onClickAddToCart(@PathVariable String productId) {
		String userId = cartClientApiService.getLogInIdForUser();
    	if(StringUtils.isEmpty(userId)) {
    		throw new RuntimeException("User not Logged in...");
    	}
    	ResponseEntity<String> response= cartClientApiService.addToCart(productId);
    	
    	log.info("Add To Cart returned with STATUS :"+response.getStatusCode());
    	
    	if(response.getStatusCode().equals(HttpStatus.OK)) { // AddToCart is success, redirect to cart page
    		return "cart";
    	}	
    	
    	return "product";
    }
	
	//This service wiil be used by other clients for getting LoggedIn User name
	@GetMapping("/get-logged-user")
	@ResponseBody
	public String getLoggedInUserName() {
		String userId = cartClientApiService.getLogInIdForUser();
		return userId;
	}
	
}
