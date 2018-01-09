package com.demo.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.domain.ProductDTO;
import com.demo.jpa.ProductRestRepository;
import com.demo.model.Product;
import com.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	private static Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRestRepository repository;
	@Override
	public List<ProductDTO> fetchProducts() {
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		Iterable<Product> itr= repository.findAll();
		for(Product prod:itr) {
	    	ProductDTO dto = new ProductDTO();
	    	log.info("Fetched ProductId:"+prod.getProductId());
	    	dto.setProductId(String.valueOf(prod.getProductId()));
	    	dto.setProductName(prod.getName());
	    	String productDesc = Optional.ofNullable(prod.getDesc()).isPresent()?prod.getDesc().get():"Not Avaialable";
	    	dto.setProductDesc(productDesc);
	    	products.add(dto);
	    }
		//products.stream().forEach(System.out::println);
		return products;
	}

}
