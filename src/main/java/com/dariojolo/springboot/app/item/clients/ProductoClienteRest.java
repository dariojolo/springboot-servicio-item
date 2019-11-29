package com.dariojolo.springboot.app.item.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dariojolo.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {

	@GetMapping("/list")
	public List<Producto>list();
	
	@GetMapping ("/search/{id}")
	public Producto search(@PathVariable Long id);
}
