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
	
	@GetMapping("/prod/{productId}")
	public Product getProduct(@PathVariable int productId)
	{
		return productService.getById(productId);
	}
	
	@GetMapping("/prods")
	public List<Product> getProducts()
	{
		return productService.getAllProducts();
	}
	
	@PostMapping("/prod")
	public String saveProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return "Saved..........";
	}
	
	@PostMapping("/prods")
	public String saveProducts(@RequestBody List<Product> products)
	{
		productService.saveProducts(products);
		return "All data Saved...........";
	}
	@PutMapping("/prod/{productId}")
	public String updateProduct(@PathVariable int productId,@RequestBody Product product)
	{
		productService.upadteProduct(productId, product);
		return "Updated............";
	}
	
	@DeleteMapping("/prod/{productId}")
	public String deleteProduct(@PathVariable int productId)
	{
		productService.deleteProduct(productId);
		return "Deleted.............";
	}
	@DeleteMapping("/prod")
	public String deleteProducts()
	{
		productService.deleteAllProducts();
		return "All data deleted.......";
	}
}
