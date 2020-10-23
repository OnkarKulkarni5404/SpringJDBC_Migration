package com.psl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.psl.beans.*;
import com.psl.service.RelationService;

@RestController
@RequestMapping("/rel")
public class RelationController {

	@Autowired
	private RelationService service;
	
	
	@GetMapping("/hello")
	public String sayhello()
	{
		return "Service is running fine";
	}
	
	
	@GetMapping("/get")
	public List<Item> getinner()
	{
		return service.getItemsInnerJoin();
	}
	
}
