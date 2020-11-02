package com.psl.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.beans.Orders;
import com.psl.service.OrderService;

@RestController
@RequestMapping(path = "/app")
public class OrderController {
	
	
	List<Orders> list=new ArrayList<Orders>();
	
	@Autowired
	private OrderService service;
	
	
	@GetMapping("/hello")
	String showData()
	{
		return "Hello Onkar";
	}
	
	
	@PutMapping("/put")
	public String saveOrder(@RequestBody Orders order) {
	
		service.insertOrder(order);
		return "Check dbase";
	}
	
	@GetMapping("/orders")
	public List<Orders> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Orders findById(@PathVariable("id") String id)
	{
		return service.FindById(id);
	}
	
	@DeleteMapping("/orders/{id}")
	public void DeleteById(@PathVariable String id)
	{
		service.deleteById(id);
	}

	/*		
	@GetMapping("/saveall")
	public String saveAll()
	{
		list.add(new Orders("ok2",new Date(),new Date(),new Date(),"Processing","Good service","0202522523"));
		list.add(new Orders("ok3",new Date(),new Date(),new Date(),"Delivered","Good service","0202522554"));
		list.add(new Orders("ok4",new Date(),new Date(),new Date(),"In Transit","Good service","0202522556"));
		list.add(new Orders("ok5",new Date(),new Date(),new Date(),"Shipped","can be improved","0202522578"));
		list.add(new Orders("ok6",new Date(),new Date(),new Date(),"Processing","Good service","020252251"));
		list.add(new Orders("ok7",new Date(),new Date(),new Date(),"Out for delievery","Late","0202522514"));
		list.add(new Orders("ok8",new Date(),new Date(),new Date(),"Delivered","bad service","0202522579"));
		list.add(new Orders("ok9",new Date(),new Date(),new Date(),"Shipped","Good service","0202522510"));
		list.add(new Orders("ok10",new Date(),new Date(),new Date(),"In Transit","Good service","0202522589"));

		for(Orders order: list){
			service.insertOrder(order);
		}		
		return "All orders saved";	
	}
	
*/
	
}
