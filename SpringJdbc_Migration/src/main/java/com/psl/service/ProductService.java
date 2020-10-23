package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.beans.Orders;
import com.psl.beans.Product;
import com.psl.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo repo;
	
	public void insertOrder(Product prod) {
		repo.save(prod);
		
	}
	
	public Product FindById(String id)
	{
		return repo.findById(id);
	}
	
	public List<Product> findAll()
	{
		return repo.findAllOrders();
	}
	
	public void deleteById(String id)
	{
		 repo.Delete(id);
	}

	
	
	
	
	
}
