package com.dariojolo.springboot.app.item.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.dariojolo.springboot.app.item.clients.ProductoClienteRest;
import com.dariojolo.springboot.app.item.models.Item;

@Service("serviceFeign")
@Primary
public class ItemServiceFeign implements ItemService {

	@Autowired
	private ProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.list().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item (clienteFeign.search(id), cantidad);
	}

}
