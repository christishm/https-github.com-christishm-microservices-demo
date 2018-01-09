package com.demo.jpa;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.Price;


public interface PriceRepository extends CrudRepository<Price,Long>{
	
	Price findByProductId(String productId);

}
