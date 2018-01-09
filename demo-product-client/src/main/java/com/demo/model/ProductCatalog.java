package com.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductCatalog {
	
	public long getCatalogId() {
		return catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCatalogId(long catalogId) {
		this.catalogId = catalogId;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Id
	private long catalogId;
	
	private String catalogName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Category> categories;
	
	public ProductCatalog() {
		super();
	}
	
	public ProductCatalog(long catalogId,String catalogName,List<Category> categories) {
		this.catalogId=catalogId;
		this.catalogName=catalogName;
		this.categories=categories;
	}

}
