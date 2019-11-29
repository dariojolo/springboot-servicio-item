package com.dariojolo.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dariojolo.springboot.app.item.models.Item;
import com.dariojolo.springboot.app.item.models.services.ItemService;

@RestController
public class ItemController {

	@Autowired
	@Qualifier("serviceFeign")
	private ItemService itemService;
	
	@GetMapping ("/list")
	public List<Item>list(){
		return itemService.findAll();
	}
	
	@GetMapping ("/search/{id}/cantidad/{cantidad}")
	public Item search(@PathVariable Long id, @PathVariable Integer cantidad){
		return itemService.findById(id, cantidad);
	}
}
