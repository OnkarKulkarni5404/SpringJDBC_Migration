package com.psl.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.psl.beans.OrderDetails;
import com.psl.beans.Product;

class OrderDetailsMapper implements RowMapper<OrderDetails> {
	
	 public OrderDetails mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		 OrderDetails order_details = new OrderDetails();
		 	order_details.setOrderNumber(resultSet.getString("order_number"));
			order_details.setProductCode(resultSet.getString("product_code"));
			order_details.setQuantityOrder(resultSet.getInt("quantity_order"));
			order_details.setPriceEach(resultSet.getFloat("price_each"));
			order_details.setOrderLineNumber(resultSet.getInt("order_line_number"));
	     return order_details;
	
	 }        
	}

@Repository
public class OrderDetailsRepo {
	@Autowired
	private JdbcTemplate jdbctemp;	
	@Autowired
	public OrderDetailsRepo(JdbcTemplate jtemp)
	{
		this.jdbctemp=jtemp;
	}
	
	//CREATE AND UPDATE
		public void save(OrderDetails order_details)
		{
			String sqlquery="insert into order_details values(?,?,?,?,?)";
			jdbctemp.update(sqlquery,
					order_details.getOrderNumber(),
					order_details.getOrderLineNumber(),
					order_details.getPriceEach(),
					order_details.getProductCode(),
					order_details.getQuantityOrder());
		}
		
		//READ_ALL
		public List<OrderDetails> findAllOrders() {
		    List<OrderDetails> orderlist=jdbctemp.query("select * from order_details", new OrderDetailsMapper());
		    return orderlist;

		}
		
		//FIND BY ID
		public OrderDetails findById(String id)
		{
			String sql="select * from order_details where order_number=?";
			return this.jdbctemp.queryForObject(sql, new Object[]{id},new OrderDetailsMapper());
		}
		
		//Delete ID
		public void Delete(String id)
		{
			jdbctemp.update("delete from order_details where order_number=?",id);
		}
	
}
