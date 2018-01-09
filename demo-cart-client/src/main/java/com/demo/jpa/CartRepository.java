package com.demo.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.CartModel;


public interface CartRepository extends CrudRepository<CartModel,Long>{
	public List<CartModel> findByUserId(String userId);
}
