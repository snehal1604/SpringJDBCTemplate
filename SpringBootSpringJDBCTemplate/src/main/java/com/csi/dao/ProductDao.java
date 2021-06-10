package com.csi.dao;

import java.util.List;

import com.csi.model.Product;

public interface ProductDao {
	
	public List<Product> getAllProducts();
	
	public void saveProduct(Product product);
	
	public void deleteProduct(int productId);
	
	public void updateProduct(int productId, Product product);
	
	public Product getById(int productId);
}
