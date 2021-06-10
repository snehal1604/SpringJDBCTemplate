package com.csi.dao;

import java.util.List;

import com.csi.model.Product;

public interface ProductDao {

	public List<Product> getAllProducts();
	
	public Product getById(int productId);
	
	public  void upadteProduct(int productId, Product product);
	
	public void deleteProduct(int productId);
	
	public void deleteAllProducts();
	
	public void saveProduct(Product product);
	
	public void saveProducts(List<Product> products);
}
