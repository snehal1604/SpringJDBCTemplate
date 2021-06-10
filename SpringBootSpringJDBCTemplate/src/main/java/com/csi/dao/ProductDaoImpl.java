package com.csi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csi.model.Product;

@Component
public class ProductDaoImpl implements ProductDao{

	@Autowired
	JdbcTemplate jdbctemplate;
	
		
	@Value("${product.query.find.all}")
	private String selectSql;
	private String insertSql="insert into product values(?,?,?,?)";
	//private String selectSql="select * from product";
	private String updateSql="update product set productname=?,productprice=?,productdate=? where productid=?";
	private String deletesql="delete from product where productid=?";
	private String getByIdSql="select * from product where productid=?"; 
	
	private Product product(ResultSet rs,int rows) throws SQLException
	{
		return Product.builder()
				.productId(rs.getInt("productid"))
				.productName(rs.getString("productname"))
				.productPrice(rs.getDouble("productprice"))
				.productDate(rs.getDate("productdate"))
				.build();
	}
	
	@Override
	public List<Product> getAllProducts() {
		
		return jdbctemplate.query(selectSql, this::product);
	}

	@Override
	public void saveProduct(Product product) {
		
		jdbctemplate.update(insertSql, product.getProductId(),product.getProductName(),product.getProductPrice(),product.getProductDate());
	}

	@Override
	public void deleteProduct(int productId) {
		
		jdbctemplate.update(deletesql, productId);
	}

	@Override
	public void updateProduct(int productId, Product product) {
		
		jdbctemplate.update(updateSql, product.getProductName(),product.getProductPrice(),product.getProductDate(),productId);
	}
	
	
	
	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
			//return jdbctemplate.query(getByIdSql, productId, this::product);
		return jdbctemplate.query(getByIdSql, this::product).get(0) ;
	}

}
