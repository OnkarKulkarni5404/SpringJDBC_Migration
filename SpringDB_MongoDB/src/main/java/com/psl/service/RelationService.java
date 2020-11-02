package com.psl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.repo.RelationJoins;
import com.psl.beans.*;


@Service
public class RelationService {

	@Autowired
	private RelationJoins rj;
	
	public List<Item> getItemsInnerJoin()
	{
		return rj.innerjoin();
	}
}
