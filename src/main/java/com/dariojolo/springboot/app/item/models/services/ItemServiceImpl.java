package com.dariojolo.springboot.app.item.models.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dariojolo.springboot.app.item.models.Item;
import com.dariojolo.springboot.app.item.models.Producto;

@Service("serviceRestTemplate")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private RestTemplate clienteRest;
	
	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		List<Producto>productos = Arrays.asList(clienteRest.getForObject("http://localhost:8001/list",Producto[].class ));
		
		return productos.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		// TODO Auto-generated method stub
		Map<String,String>pathVaribles = new HashMap<String, String>();
		pathVaribles.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/search/{id}", Producto.class, pathVaribles);
		return new Item(producto, cantidad);
	}

}
