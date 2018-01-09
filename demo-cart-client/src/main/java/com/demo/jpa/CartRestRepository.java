package com.demo.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.model.CartModel;


@RepositoryRestResource(path="/")
public interface CartRestRepository extends PagingAndSortingRepository<CartModel, Long>{

}
