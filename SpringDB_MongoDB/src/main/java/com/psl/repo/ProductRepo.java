package com.psl.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.psl.beans.Product;

@Repository
public class ProductRepo {

	@Autowired
	private MongoTemplate mtemp;
	
	@Autowired
	public ProductRepo(MongoTemplate mtemp)
	{
		this.mtemp=mtemp;
	}
	
	//CREATE AND UPDATE
		public void save(Product prod)
		{
			mtemp.save(prod);
		}
		
		//READ_ALL
		public List<Product> findAllOrders() {
			return mtemp.findAll(Product.class);
		}
		
		//FIND BY ID
		public Product findById(String id)
		{
			return mtemp.findById(id, Product.class);
		}
		
		//Delete ID
		public void Delete(String id)
		{
			Product prod=mtemp.findById(id, Product.class);
			mtemp.remove(prod);
		}
}
