package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.jpa.InventoryRepository;
import com.demo.model.InventoryInfo;
import com.demo.service.InventoryService;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Override
	public InventoryInfo findInventoryInfo(String productId) {
		return inventoryRepository.findByProductId(productId);
	}

}
