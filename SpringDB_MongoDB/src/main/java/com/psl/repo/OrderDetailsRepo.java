package com.psl.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.psl.beans.OrderDetails;



@Repository
public class OrderDetailsRepo {

	 
	@Autowired
	MongoTemplate mongotemp;
	
	
	
	//CREATE AND UPDATE
		public void save(OrderDetails order_details)
		{
			mongotemp.save(order_details);
		}
		
		//READ_ALL
		public List<OrderDetails> findAllOrders() {
				return mongotemp.findAll(OrderDetails.class);

		}
		
		//FIND BY ID
		public OrderDetails findById(String id)
		{
			return mongotemp.findById(id, OrderDetails.class);
			
		}
		
		//Delete ID
		public void Delete(String id)
		{
			OrderDetails ord=mongotemp.findById(id, OrderDetails.class);
			mongotemp.remove(ord);
		}
	
}
