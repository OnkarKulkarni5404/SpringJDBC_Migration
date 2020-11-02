package com.psl.beans;

import java.util.Date;

public class Item{
	
	
	private String order_number;
	private int order_line_number;
	private float price_each;
	private String product_code;
	private int quantity_order;
	
	 private Date order_date;
	 private String comment;
	 private String cust_number ;
	 private Date req_date;
	 private Date shipped_date ;
	 private String stauts;
	 
	 private float  buy_price;
	 private String product_name;
	 private String product_vendor;
	 private int quantity_in_stock;
	 
	public float getBuy_price() {
		return buy_price;
	}
	public void setBuy_price(String buy_price) {
		this.buy_price = Float.parseFloat(buy_price);
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_vendor() {
		return product_vendor;
	}
	public void setProduct_vendor(String product_vendor) {
		this.product_vendor = product_vendor;
	}
	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}
	public void setQuantity_in_stock(String quantity_in_stock) {
		this.quantity_in_stock = Integer.parseInt(quantity_in_stock);
	}
	public String getOrder_number() {
		return order_number;
	}
	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}
	public int getOrder_line_number() {
		return order_line_number;
	}
	public void setOrder_line_number(String order_line_number) {
		this.order_line_number = Integer.parseInt(order_line_number.trim());
	}
	public float getPrice_each() {
		return price_each;
	}
	public void setPrice_each(String price_each) {
		this.price_each = Float.parseFloat(price_each);
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public int getQuantity_order() {
		return quantity_order;
	}
	public void setQuantity_order(String quantity_order) {
		this.quantity_order = Integer.parseInt(quantity_order);
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = new Date(order_date);
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	public Date getReq_date() {
		return req_date;
	}
	public void setReq_date(String req_date) {
		this.req_date = new Date(req_date);
	}
	public Date getShipped_date() {
		return shipped_date;
	}
	public void setShipped_date(String shipped_date) {
		this.shipped_date = new Date(shipped_date);
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	@Override
	public String toString() {
		return "Item [order_number=" + order_number + ", order_line_number="
				+ order_line_number + ", price_each=" + price_each
				+ ", product_code=" + product_code + ", quantity_order="
				+ quantity_order + ", order_date=" + order_date + ", comment="
				+ comment + ", cust_number=" + cust_number + ", req_date="
				+ req_date + ", shipped_date=" + shipped_date + ", stauts="
				+ stauts + ", buy_price=" + buy_price + ", product_name="
				+ product_name + ", product_vendor=" + product_vendor
				+ ", quantity_in_stock=" + quantity_in_stock + "]";
	}
	
	
	
	
}