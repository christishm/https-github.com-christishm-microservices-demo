package com.demo.jpa;

import org.springframework.data.repository.CrudRepository;

import com.demo.model.Category;
import com.demo.model.ProductCatalog;


public interface ProductCatalogRepository extends CrudRepository<ProductCatalog,Long>{

}
