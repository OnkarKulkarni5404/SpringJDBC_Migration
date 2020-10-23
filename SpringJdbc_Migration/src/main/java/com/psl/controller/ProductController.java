package com.psl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.beans.Product;
import com.psl.service.ProductService;

@RestController
@RequestMapping("/pc")
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello, I am running";
	}
	
	@PutMapping("/put")
	public String saveOrder(@RequestBody Product prod) {
	
		service.insertOrder(prod);
		return "Check dbase";
	}
	
	@GetMapping("/products")
	public List<Product> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product findById(@PathVariable("id") String id)
	{
		return service.FindById(id);
	}
	
	@DeleteMapping("/products/{id}")
	public void DeleteById(@PathVariable String id)
	{
		service.deleteById(id);
	}
	
	
	public String saveall()
	{
		/*String productCode, String productName, String productVendor, Integer quantityInStock,
			Float buyPrice*/
		List<Product> list=new ArrayList<Product>();
		list.add(new Product("A12","Papads","Home-mart",1000,new Float(43.33)));
		list.add(new Product("A13","Aleovera","Herbal-care",500,new Float(45.99)));
		list.add(new Product("A14","Amla","Herbal-care",78,new Float(50.99)));
		list.add(new Product("A15","Samsung-101","Samsung",45,new Float(1499.99)));
		list.add(new Product("A16","Redmi-189","Redmi",2000,new Float(11999.99)));
		list.add(new Product("A17","Intex-899","Intex",8000,new Float(9999.99)));
		list.add(new Product("A18","Pixel a4","Google",1500,new Float(29999.99)));
		list.add(new Product("A19","One Plus Nord","MI",1300,new Float(31999.99)));
		list.add(new Product("A20","LG LED OG102M","LG",200,new Float(33999.99)));
		list.add(new Product("A21","Nvidia 1080T","Nvidia",100,new Float(25043.33)));
		
		for(Product prod:list)
		{
			this.service.insertOrder(prod);
		}
		
		return "Check Dbase";
	}
	
	
	
	
	
}
