package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InventoryInfo {
	
	@Id
	private long inventoryId;
	
	private String productId;
	
	private String inventoryStatus;
	
	
	public InventoryInfo() {
		super();
	}

	@Override
	public String toString() {
		return "InventoryInfo [productId=" + productId + ", inventoryStatus=" + inventoryStatus + "]";
	}

	public InventoryInfo(long inventoryId, String productId, String inventoryStatus) {
		super();
		this.inventoryId = inventoryId;
		this.productId = productId;
		this.inventoryStatus = inventoryStatus;
	}

	public long getInventoryId() {
		return inventoryId;
	}

	public String getProductId() {
		return productId;
	}

	public String getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryId(long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setInventoryStatus(String inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
	}
	
	

}
