package com.demo.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.model.Product;

@RepositoryRestResource(path="/")
public interface ProductRestRepository extends PagingAndSortingRepository<Product, Long>{

}
