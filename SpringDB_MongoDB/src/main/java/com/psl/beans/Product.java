package com.psl.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {

	@Id
	String productCode;
	
	String productName;
	String productVendor;
	Integer quantityInStock;
	Float buyPrice;
	
	public Product() {
	}

	public Product(String productCode, String productName, String productVendor, Integer quantityInStock,
			Float buyPrice) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productVendor = productVendor;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductVendor() {
		return productVendor;
	}
	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}
	public Integer getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public Float getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Float buyPrice) {
		this.buyPrice = buyPrice;
	}	
}
