package com.csi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csi.dao.ProductDaoImpl;
import com.csi.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDaoImpl productDao;
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAllProducts();
	}

	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.saveProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		productDao.deleteProduct(productId);
	}

	@Override
	public void updateProduct(int productId, Product product) {
		// TODO Auto-generated method stub
		productDao.updateProduct(productId, product);
	}

}
