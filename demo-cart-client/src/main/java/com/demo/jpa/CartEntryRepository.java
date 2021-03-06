package com.demo.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.CartEntry;

/**
Repositoy Design Pattern is used to provide data persistence and retrieval abstraction for the Domain Model objects.
Hibernate based implentation for JPA interfaces.Uses auto configured datasource(provided by Spring Boot).
*/
public interface CartEntryRepository extends CrudRepository<CartEntry,Long>{
	
	List<CartEntry> findByProductId(String productId);
	List<CartEntry> findByUserId(String userId);
	
}
