package com.demo.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.model.CartModel;

/**
 Declarative REST template which exposes all the DAO methods in Repistory Layer as RESTful apis.
*/
@RepositoryRestResource(path="/")
public interface CartRestRepository extends PagingAndSortingRepository<CartModel, Long>{

}
