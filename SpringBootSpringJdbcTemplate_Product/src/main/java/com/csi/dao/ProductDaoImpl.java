package com.csi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csi.model.Product;

@Component
public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbctemplate;

	private String saveSql = "insert into product values(?,?,?,?)";
	private String selectSql = "select * from product";
	private String selectByIdSql = "select * from product where productid=?";
	private String deleteSql = "delete from product where productid=?";
	private String deleteAllSql = "delete from product";
	private String updateSql = "update product set productname=?,productprice=?,productdate=? where productid=?";

	private Product product(ResultSet rs, int rows) throws SQLException {
		return Product.builder().productId(rs.getInt("productid")).productName(rs.getString("productname"))
				.productPrice(rs.getDouble("productprice")).productDate(rs.getDate("productdate")).build();
	}

	@Override
	public List<Product> getAllProducts() {
		return jdbctemplate.query(selectSql, this::product);
	}

	@Override
	public Product getById(int productId) {
		return jdbctemplate.query(selectByIdSql, this::product, productId).get(0);
	}

	@Override
	public void upadteProduct(int productId, Product product) {
		jdbctemplate.update(updateSql, product.getProductName(), product.getProductPrice(), product.getProductDate(),
				productId);
	}

	@Override
	public void deleteProduct(int productId) {
		jdbctemplate.update(deleteSql, productId);
	}

	@Override
	public void deleteAllProducts() {
		jdbctemplate.update(deleteAllSql);
	}

	@Override
	public void saveProduct(Product product) {
		jdbctemplate.update(saveSql, product.getProductId(), product.getProductName(), product.getProductPrice(),
				product.getProductDate());
	}

	@Override
	public void saveProducts(List<Product> products) {
		for (Product prod : products) {
			jdbctemplate.update(saveSql, prod.getProductId(), prod.getProductName(), prod.getProductPrice(),
					prod.getProductDate());
		}
	}

}
