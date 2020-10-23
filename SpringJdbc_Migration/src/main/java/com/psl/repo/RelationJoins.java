package com.psl.repo;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.lang.reflect.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.psl.beans.Item;



class ItemMapper implements RowMapper<Item> {

	 public Item mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		 Item item=new Item();
		 ResultSetMetaData rsmd=resultSet.getMetaData();
		 int colCount=rsmd.getColumnCount();
		 System.out.println("Column count is "+colCount);
		
		 
		 
		 for(int i=1;i<=colCount;i++)
		 {	
			 
			 String Resultsetcolname=rsmd.getColumnName(i);
			 String mname=Character.toUpperCase(Resultsetcolname.charAt(0))+Resultsetcolname.substring(1);
			 
			 Method method = null;
			 try {
				 method=Item.class.getMethod("set"+mname.trim(), String.class);
				method.invoke(item, resultSet.getString(i));
				
				 
				 
			 } catch (NoSuchMethodException e) {
				 System.out.println("set"+mname+" Not found method");
				 e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }      
		 return item;
	}}


@Repository
public class RelationJoins {

	@Autowired
	private JdbcTemplate jdbctemplate;
	
	public List<Item> innerjoin()
	{
		String sql="select product.product_name,order_details.quantity_order "
				+ "from product inner join order_details "
				+ "on product.product_code=order_details.product_code"
				+ " inner join orders "
				+ "on order_details.order_number=orders.order_number";
		List<Item> items=jdbctemplate.query(sql,new ItemMapper());
		return items;
	}
	
}
