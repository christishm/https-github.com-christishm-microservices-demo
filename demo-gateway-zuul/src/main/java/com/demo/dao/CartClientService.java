package com.demo.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("CART-SERVICE")
public interface CartClientService {

	@RequestMapping(value="/add-to-cart/{productId}",method=RequestMethod.POST,consumes = "application/json")
	ResponseEntity<String> addToCart(@PathVariable("productId") String productId);
	
}
