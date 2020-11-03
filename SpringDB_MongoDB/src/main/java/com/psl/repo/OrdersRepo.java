package com.psl.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.psl.beans.Orders;


@Repository
public class OrdersRepo {

	@Autowired
	private final MongoTemplate mtemp;
	
	@Autowired
	public OrdersRepo(MongoTemplate mtemp) {
		this.mtemp=mtemp;
	}
	
	
	//CREATE AND UPDATE
	public void save(Orders order)
	{
		mtemp.save(order);
	}
	
	//READ_ALL
	public List<Orders> findAllOrders() {
	   return mtemp.findAll(Orders.class);
	}
	
	//FIND BY ID
	public Orders findById(String id)
	{
		return mtemp.findById(id, Orders.class);
	}
	
	//Delete ID
	public void Delete(String id)
	{

		Orders order=mtemp.findById(id, Orders.class);
		mtemp.remove(order);
	}
	
}



