package com.psl.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;



@Entity
@Table(name = "order_details")
public class OrderDetails {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_number")
	private String orderNumber;
	@Column(name="product_code")
	private String productCode;
	private Integer quantityOrder;
	private Float priceEach;
	private Integer orderLineNumber;
	
	
	public OrderDetails(){
		
	}
	
	public OrderDetails(String orderNumber, String productCode, Integer quantityOrder, Float priceEach,
			Integer orderLineNumber) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
		this.quantityOrder = quantityOrder;
		this.priceEach = priceEach;
		this.orderLineNumber = orderLineNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getQuantityOrder() {
		return quantityOrder;
	}
	public void setQuantityOrder(Integer quantityOrder) {
		this.quantityOrder = quantityOrder;
	}
	public Float getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(Float priceEach) {
		this.priceEach = priceEach;
	}
	public Integer getOrderLineNumber() {
		return orderLineNumber;
	}
	public void setOrderLineNumber(Integer orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
	
}
