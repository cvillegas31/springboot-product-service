package com.ecommerce.springboot.app.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.springboot.app.products.models.entity.Product;
import com.ecommerce.springboot.app.products.models.service.IProductsService;

@RestController
public class ProductController {
	
	//@Autowired
	//private Environment env;
	
	@Value("${server.port}")
	private Integer port;	
	
	@Autowired
	IProductsService iProductsService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		return iProductsService.findAll().stream().map(product ->{
			//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/productDetail/{id}")
	public Product getProducts(@PathVariable Long id) {
		Product product = iProductsService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		product.setPort(port);
		return product;
	}
		 

}
