package com.demo.jpa;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.InventoryInfo;



@Component
public class InventoryInfoCommandLineRunner implements CommandLineRunner{
		
	public static Logger log = LoggerFactory.getLogger(InventoryInfoCommandLineRunner.class);
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		inventoryRepository.save(new InventoryInfo(11111,"10001","InStock"));
		inventoryRepository.save(new InventoryInfo(22222,"10002","InStock"));
		inventoryRepository.save(new InventoryInfo(33333,"10003","OutOfStock"));
	
		for (InventoryInfo inventoryInfo : inventoryRepository.findAll()) {
			log.info(inventoryInfo.toString());
		}
	}

}
