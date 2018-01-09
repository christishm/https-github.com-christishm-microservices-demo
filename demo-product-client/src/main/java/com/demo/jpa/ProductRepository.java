package com.demo.jpa;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{

}
