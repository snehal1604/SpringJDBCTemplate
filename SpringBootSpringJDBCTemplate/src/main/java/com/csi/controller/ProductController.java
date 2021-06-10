package com.csi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductServiceImpl productService;
	
	@GetMapping("/prod")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
		
	@PutMapping("/prod/{productId}")
	public String updateProduct(@PathVariable int productId, @RequestBody Product product)
	{
		productService.updateProduct(productId, product);
		return "updated...........";
	}
	
	@PostMapping("/prod")
	public String saveProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return "saved..............";
	}
	
	@DeleteMapping("/prod/{productId}")
	//public String deleteProduct(@PathVariable int productId)
	public String deleteProduct()
	{
		productService.deleteProduct(1);
		return "deleted.........";
	}
}
