package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Price;
import com.demo.service.PriceService;


@RestController
public class PriceController {
	
	@Autowired
	PriceService priceService;
		
	@GetMapping("/{prodId}")
	public Price fetchPrice(@PathVariable("prodId") String prodId) {
		return priceService.fetchPrice(prodId);
	}
}
