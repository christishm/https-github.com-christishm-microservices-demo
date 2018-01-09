package com.demo.service;

import java.util.List;

import com.demo.domain.ProductDTO;

public interface ProductService {
	
	List<ProductDTO> fetchProducts();

}
