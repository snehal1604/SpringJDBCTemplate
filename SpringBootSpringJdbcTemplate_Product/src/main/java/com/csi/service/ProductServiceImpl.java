package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.csi.dao.ProductDaoImpl;
import com.csi.model.Product;

@Component
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDaoImpl productDao;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		return productDao.getById(productId);
	}
	@Override
	public void upadteProduct(int productId, Product product) {
		// TODO Auto-generated method stub
		productDao.upadteProduct(productId, product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(productId);
	}

	@Override
	public void deleteAllProducts() {
		// TODO Auto-generated method stub
		productDao.deleteAllProducts();
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.saveProduct(product);
	}

	@Override
	public void saveProducts(List<Product> products) {
		// TODO Auto-generated method stub
		productDao.saveProducts(products);
	}

}
