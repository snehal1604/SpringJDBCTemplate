package com.csi.service;

import java.util.List;

import com.csi.model.Product;

public interface ProductService {
public List<Product> getAllProducts();
	
	public void saveProduct(Product product);
	
	public void deleteProduct(int productId);
	
	public void updateProduct(int productId, Product product);
}
