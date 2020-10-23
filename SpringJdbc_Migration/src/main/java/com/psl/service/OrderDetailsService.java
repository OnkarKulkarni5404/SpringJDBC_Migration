package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.beans.OrderDetails;
import com.psl.beans.Product;
import com.psl.repo.OrderDetailsRepo;
import com.psl.repo.ProductRepo;

@Service
public class OrderDetailsService {

	@Autowired
	private OrderDetailsRepo repo;
	
	public void insertOrder(OrderDetails odetails) {
		repo.save(odetails);
		
	}
	public OrderDetails FindById(String id)
	{
		return repo.findById(id);
	}
	
	public List<OrderDetails> findAll()
	{
		return repo.findAllOrders();
	}
	
	public void deleteById(String id)
	{
		 repo.Delete(id);
	}
	
}
