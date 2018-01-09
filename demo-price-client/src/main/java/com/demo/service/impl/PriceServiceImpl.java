package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.PriceRepository;
import com.demo.model.Price;
import com.demo.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	PriceRepository priceRepository;

	@Override
	public Price fetchPrice(String productId) {
		return priceRepository.findByProductId(productId);
	}

}
