package com.demo.domain;

public class ProductDTO {

	public ProductDTO(String productId, String productName, String productDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
	}
	
	public ProductDTO() {
		super();
	}

	private String productId;
	
	private String productName;
	
	private String productDesc;

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + "]";
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
}
