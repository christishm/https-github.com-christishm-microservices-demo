package com.demo.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.CartEntry;


public interface CartEntryRepository extends CrudRepository<CartEntry,Long>{
	
	List<CartEntry> findByProductId(String productId);
	List<CartEntry> findByUserId(String userId);
	
}
