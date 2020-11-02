package com.psl.repo;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.psl.beans.OrderDetails;



@Repository
public interface OrderDetailsRepo extends MongoTemplate<OrderDetails,String>{

	 
	
	//CREATE AND UPDATE
		public void save(OrderDetails order_details)
		{
		}
		
		//READ_ALL
		public List<OrderDetails> findAllOrders() {

		}
		
		//FIND BY ID
		public OrderDetails findById(String id)
		{
		}
		
		//Delete ID
		public void Delete(String id)
		{
		}
	
}
