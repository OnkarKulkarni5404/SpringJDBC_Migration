package com.psl.controller;

import java.sql.SQLException;
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

import com.psl.beans.OrderDetails;
import com.psl.service.OrderDetailsService;

@RestController
@RequestMapping("/od")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService service;
	
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello, I am running";
	}
	
	
	@PutMapping("/put")
	public String saveOrder(@RequestBody OrderDetails odetails) {
	
		service.insertOrder(odetails);
		return "Check dbase";
	}
	
	@GetMapping("/")
	public List<OrderDetails> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public OrderDetails findById(@PathVariable("id") String id)
	{
		return service.FindById(id);
	}
	
	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable String id)
	{
		service.deleteById(id);
	}
	
	@GetMapping("/saveall")
	public String saveall()
	{
		/*String orderNumber, String productCode, Integer quantityOrder, Float priceEach,
			Integer orderLineNumber
		 * */
		List<OrderDetails> list=new ArrayList<OrderDetails>();
		list.add(new OrderDetails("ok3","A12",1,new Float(43.33),120));
		list.add(new OrderDetails("ok4","A14",3,new Float(50.99),125));
		list.add(new OrderDetails("ok5","A15",4,new Float(1499.99),121));
		list.add(new OrderDetails("ok6","A16",2,new Float(1200),133));
		list.add(new OrderDetails("ok7","A13",19,new Float(150.33),178));
		list.add(new OrderDetails("ok8","A14",1,new Float(400.99),119));
		
		for(OrderDetails od: list)
			{
				this.service.insertOrder(od);
			}
		
		
		
		
		return "Check Dbase";
	}
	
	
}
