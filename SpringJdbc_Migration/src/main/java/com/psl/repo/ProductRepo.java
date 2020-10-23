package com.psl.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.psl.beans.Product;

class ProductMapper implements RowMapper<Product> {
	
	 public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		 Product product = new Product();
	     product.setProductCode(resultSet.getString("product_code"));
			product.setBuyPrice(resultSet.getFloat("buy_price"));
			product.setProductName(resultSet.getString("product_name"));
			product.setProductVendor(resultSet.getString("product_vendor"));
			product.setQuantityInStock(resultSet.getInt("quantity_in_stock"));
	     return product;
	
	 }        
	}

@Repository
public class ProductRepo {

	@Autowired
	private JdbcTemplate jdbctemp;
	
	@Autowired
	public ProductRepo(JdbcTemplate jtemp)
	{
		this.jdbctemp=jtemp;
	}
	
	//CREATE AND UPDATE
		public void save(Product prod)
		{
			String sqlquery="insert into product values(?,?,?,?,?)";
			jdbctemp.update(sqlquery,
					prod.getProductCode(),
					prod.getBuyPrice(),
					prod.getProductName(),
					prod.getProductVendor(),
					prod.getQuantityInStock());
		}
		
		//READ_ALL
		public List<Product> findAllOrders() {
		    List<Product> orderlist=jdbctemp.query( "select * from product", new ProductMapper());
		    return orderlist;

		}
		
		//FIND BY ID
		public Product findById(String id)
		{
			String sql="select * from product where product_code=?";
			return this.jdbctemp.queryForObject(sql, new Object[]{id},new ProductMapper());
		}
		
		//Delete ID
		public void Delete(String id)
		{
			jdbctemp.update("delete from product where product_code=?",id);
		}
}
