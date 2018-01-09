package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.InventoryInfo;
import com.demo.service.InventoryService;


@RestController
public class InventoryInfoController {
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("/{prodId}")
	public InventoryInfo getInventoryInfo(@PathVariable("prodId") String prodId) {
		return inventoryService.findInventoryInfo(prodId);
	}

}
