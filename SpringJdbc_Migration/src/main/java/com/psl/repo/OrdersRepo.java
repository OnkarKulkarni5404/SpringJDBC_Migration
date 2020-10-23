package com.psl.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.psl.beans.Orders;



//Converting resultSet into Orders List
class OrderMapper implements RowMapper<Orders> {

 public Orders mapRow(ResultSet resultSet, int rowNum) throws SQLException {
     Orders order = new Orders();
     order.setOrderNumber(resultSet.getString("order_number"));
		order.setOrderDate(resultSet.getDate("order_date"));
		order.setReqDate(resultSet.getDate("req_date"));
		order.setShippedDate(resultSet.getDate("shipped_date"));
		order.setStauts(resultSet.getString("stauts"));
		order.setComment(resultSet.getString("comment"));
		order.setCustNumber(resultSet.getString("cust_number"));
     return order;
 }        
}


@Repository
public class OrdersRepo {

	@Autowired
	private final JdbcTemplate jdbctemp;
	
	@Autowired
	public OrdersRepo(JdbcTemplate jdbctemp) {
		this.jdbctemp=jdbctemp;
	}
	
	
	//CREATE AND UPDATE
	public void save(Orders order)
	{
		String sqlquery="insert into orders values(?,?,?,?,?,?,?)";
		jdbctemp.update(sqlquery,
				order.getOrderNumber(),
				order.getOrderDate(),
				order.getComment(),
				order.getCustNumber(),
				order.getReqDate(),
				order.getShippedDate(),
				order.getStauts());
	}
	
	//READ_ALL
	public List<Orders> findAllOrders() {
	    List<Orders> orderlist=jdbctemp.query( "select * from orders", new OrderMapper());
	    return orderlist;

	}
	
	//FIND BY ID
	public Orders findById(String id)
	{
		String sql="select * from orders where order_number=?";
		return this.jdbctemp.queryForObject(sql, new Object[]{id},new OrderMapper());
	}
	
	//Delete ID
	public void Delete(String id)
	{
		jdbctemp.update("delete from orders where order_id=?",id);
	}
	
}



