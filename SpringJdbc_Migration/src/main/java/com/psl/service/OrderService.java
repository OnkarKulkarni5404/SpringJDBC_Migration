package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.beans.Orders;
import com.psl.repo.OrdersRepo;

@Service("service")
public class OrderService {
	
	@Autowired
	private OrdersRepo repo;
	

	public void insertOrder(Orders order) {
		repo.save(order);
		
	}
	
	public Orders FindById(String id)
	{
		return repo.findById(id);
	}
	
	public List<Orders> findAll()
	{
		return repo.findAllOrders();
	}
	
	public void deleteById(String id)
	{
		 repo.Delete(id);
	}
	
}
