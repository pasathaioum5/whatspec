package net.pasathaioum5network.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlOrder {
Connection con = DBConnect.connectToDB();
	
	public ArrayList<Order> searchOrderbyID(String id){
		ArrayList<Order> list = new ArrayList<Order>();
		try{
			
			Statement stm = con.createStatement();
			String sql = "select * from whatspec.order where order_id ="+ id;
			System.out.println("sql == " + sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())	{
				Order order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setCustomer_name(rs.getString("customer_name"));
				order.setProduct_name(rs.getString("product_name"));
				order.setProduct_amount(rs.getString("product_amount"));
				order.setTelephone(rs.getString("telephone"));
								
				list.add(order);				
				
			}
		}catch(Exception ex){
			System.out.print("SqlOrder.SqlOrder"+ ex.getMessage());
		}
		return list;
		
	}
	
	public ArrayList<Order> searchOrderbyName(String name){
		ArrayList<Order> list = new ArrayList<Order>();
		try{
			Statement stm = con.createStatement();
			String sql = "select * from whatspec.order where customer_name like  '%"+ name + "%'";
			System.out.println("sql == " + sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())	{
				Order order = new Order();
				order.setOrder_id(rs.getInt("order_id"));
				order.setCustomer_name(rs.getString("customer_name"));
				order.setProduct_name(rs.getString("product_name"));
				order.setProduct_amount(rs.getString("product_amount"));
				order.setTelephone(rs.getString("telephone"));
								
				list.add(order);				
				
			}
		}catch(Exception ex){
			System.out.print("SqlOrder.SqlOrder"+ ex.getMessage());
		}
		return list;
		
	}
	
	
	
	
	public ArrayList<Order> searchAll(){
		
		ArrayList<Order> list = new ArrayList<Order>();
		
		try{	
		    Statement stm = con.createStatement();
			String sql = "select * from whatspec.order ";
			ResultSet rs = stm.executeQuery(sql);
			
		while(rs.next())	{
			Order order = new Order();
			
			order.setOrder_id(rs.getInt("order_id"));
			order.setCustomer_name(rs.getString("customer_name"));
			order.setProduct_name(rs.getString("product_name"));
			order.setProduct_amount(rs.getString("product_amount"));
			order.setTelephone(rs.getString("telephone"));
			
			list.add(order);		
			System.out.println("size == "+list.size());
			
		}
		
		}catch(SQLException ex){
		
			System.out.println("SqlOrder:searchAll:err:"+ex.getErrorCode() +": "+ex.getMessage());
		
		}
		return list;
		
	}
	public void deleteorder(String order){
		
		  String sql = "delete from whatspec.order "		  		     	     
				     + "where order_id = ?";
	    try{  
	      PreparedStatement preparedStmt = con.prepareStatement(sql);
	      preparedStmt.setString(1, order);
	 
	     
	      preparedStmt.execute();
    }catch(Exception ex){
			
			System.out.println("SqlProduct:updateProduct:err:"+ex.getMessage());
		
		} 
	}
}
