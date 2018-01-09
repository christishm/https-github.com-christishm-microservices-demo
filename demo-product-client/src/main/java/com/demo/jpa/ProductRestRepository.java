package com.demo.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.model.Product;

/**
Declarative REST template which exposes all the DAO methods in Repistory Layer as RESTful apis.
*/
@RepositoryRestResource(path="/")
public interface ProductRestRepository extends PagingAndSortingRepository<Product, Long>{

}
