package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.GatewayClientService;
import com.demo.model.CartEntry;
import com.demo.service.CartService;

/**
Controller class used to map incoming client requests to service layer.
FrontEndController design pattern using auto configured DispatcherViewServlet(using SpringBoot autoconfiguration).
The auto configured DispatcherViewServlet will have mappings to all service URLs.
*/

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@Autowired
	GatewayClientService gateWayService;
	
	@PostMapping("/add-to-cart/{productId}")
	public ResponseEntity<String> addToCart(@PathVariable String productId) {
	    ResponseEntity<String> responseEntity;
	    String userId = gateWayService.getLoggedInUserName();
	    System.out.println("UserId..................................."+userId);
		boolean success = cartService.addToCart(userId, productId);
		if(success) {
			responseEntity = new ResponseEntity<>("Added to Cart",HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<>("Add to Cart failed",HttpStatus.NO_CONTENT);
		}
		
		return responseEntity;
		
		
	}
	
	//Used to populate Cart Page
	@GetMapping("/cart-details")
	@ResponseBody
	public List<CartEntry> getCartEntries(){
		String userId = gateWayService.getLoggedInUserName();
		return cartService.getCartEntries(userId);
	}
	
	@PostMapping("/update-cart/{productId}/{quantity}") 
	public ResponseEntity<String> updateCartEntry(@PathVariable String productId,@PathVariable Integer quantity){
		ResponseEntity<String> responseEntity;
		boolean success = cartService.updateCartEntry(productId, quantity);
		if(success) {
			responseEntity = new ResponseEntity<>("Update is Success",HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<>("Update Failed",HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	@PostMapping("/delete-cart/{productId}") 
	public ResponseEntity<String> deleteCartEntry(@PathVariable String productId){
		ResponseEntity<String> responseEntity;
		boolean success = cartService.deleteCartEntry(productId);
		if(success) {
			responseEntity = new ResponseEntity<>("Delete is Success",HttpStatus.OK);
		}else {
			responseEntity = new ResponseEntity<>("Delete Failed",HttpStatus.NO_CONTENT);
		}
		return responseEntity;
	}
	
	

}
