package com.demo.controller;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;


import com.demo.domain.ProductDTO;
import com.demo.service.ProductService;

@RunWith(SpringRunner.class)
public class ProductControllerTest {
	
	@MockBean
	private ProductService productService;
	
	
	/* Test for ProductInfo microservice rest calls */
	@Test
	public void testProductRestService() {
		
	   when().
         get("http://localhost:8888/").
       then().
       statusCode(200).
       body("productId[0]",equalTo("10001")).and().body("productName[0]", equalTo("DummyProduct1")).and().body("productId[1]",equalTo("10002"));
		
	}
	
	
	@Test
	public void testProductServiceOne() throws Exception{
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		ProductDTO product = new ProductDTO("product1","testproduct","testproductdesc");
		products.add(product);
		Mockito.when(productService.fetchProducts()).thenReturn(products);
		assertEquals("product1",productService.fetchProducts().get(0).getProductId());
		
	}
	
	@Test
	public void testProductServiceTwo() throws Exception{
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		ProductDTO product = new ProductDTO("product2","testproduct",null);
		ProductDTO product1 = new ProductDTO("product1","testproduct1","NotAvailable");
		products.add(product);
		products.add(product1);
		Mockito.when(productService.fetchProducts()).thenReturn(products);
		assertEquals(2,productService.fetchProducts().size());
		
	}

	
	
}
