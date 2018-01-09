package com.demo.jpa;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.InventoryInfo;


public interface InventoryRepository extends CrudRepository<InventoryInfo,Long>{
	
	InventoryInfo findByProductId(String productId);
}
