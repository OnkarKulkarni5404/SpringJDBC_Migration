package com.psl.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_number")
	private String OrderNumber;
	
	private Date OrderDate;
	private Date reqDate;
	private Date shippedDate;
	private String stauts;
	private String comment;
	private String custNumber;
	
	@OneToOne(mappedBy="orders")
	private Product product;
	
	public Orders() {}	

	public Orders(String orderNumber,String custNumber) {
		this.OrderNumber=orderNumber;
		this.custNumber=custNumber;
	}
	
	public Orders(String orderNumber, Date orderDate, Date reqDate, Date shippedDate, String stauts, String comment,
			String custNumber) {
		super();
		this.OrderNumber = orderNumber;
		this.OrderDate = orderDate;
		this.reqDate = reqDate;
		this.shippedDate = shippedDate;
		this.stauts = stauts;
		this.comment = comment;
		this.custNumber = custNumber;
	}
	public String getOrderNumber() {
		return OrderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		OrderNumber = orderNumber;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public Date getReqDate() {
		return reqDate;
	}
	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}
	public Date getShippedDate() {
		return shippedDate;
	}
	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}
	public String getStauts() {
		return stauts;
	}
	public void setStauts(String stauts) {
		this.stauts = stauts;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCustNumber() {
		return custNumber;
	}
	public void setCustNumber(String custNumber) {
		this.custNumber = custNumber;
	}

	@Override
	public String toString() {
		return "Orders [OrderNumber=" + OrderNumber + ", OrderDate="
				+ OrderDate + ", reqDate=" + reqDate + ", shippedDate="
				+ shippedDate + ", stauts=" + stauts + ", comment=" + comment
				+ ", custNumber=" + custNumber + "]";
	}
	

}
