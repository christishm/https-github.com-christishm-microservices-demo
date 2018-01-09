package com.demo.jpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.Category;
import com.demo.model.Product;
import com.demo.model.ProductCatalog;

@Component
public class ProductCommandLineRunner implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CatagoryRepository categoryRepository;

	@Autowired
	private ProductCatalogRepository catalogRepository;
	
	public static Logger log = LoggerFactory.getLogger(ProductCommandLineRunner.class);
	
	@Override
	public void run(String... arg0) throws Exception {
			
		productRepository.save(new Product(new Long(10001),"DummyProduct1","DummyProductOne"));
		productRepository.save(new Product(new Long(10002),"DummyProduct2","DummyProductTwo"));
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(new Long(10001),"DummyProduct1","DummyProductOne"));
		products.add(new Product(new Long(10002),"DummyProduct2","DummyProductTwo"));
		
		categoryRepository.save(new Category(new Long(20001),"DummyCategory",products));
	
		
		
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(new Long(20001),"DummyCategory",products));
		
		catalogRepository.save(new ProductCatalog(new Long(30001),"DummyCatalog",categories));
		
		
		
		for (Product product : productRepository.findAll()) {
			log.info(product.toString());
		}
	}

}
