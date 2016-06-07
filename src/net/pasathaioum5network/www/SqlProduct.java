package net.pasathaioum5network.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.pasathaioum5network.www.SqlProduct;
import net.pasathaioum5network.www.DBConnect;

public class SqlProduct {

Connection con = DBConnect.connectToDB();
	
	public ArrayList<Product> searchProductbyID(String id){
		ArrayList<Product> list = new ArrayList<Product>();
		try{
			
			Statement stm = con.createStatement();
			String sql = "select * from product where product_id ="+ id;
			System.out.println("sql == " + sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())	{
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_amount(rs.getString("product_amount"));
				product.setProduct_price(rs.getString("product_price"));
//				product.setProduct_price(rs.getString("product_regdate"));
								
				list.add(product);				
				
			}
		}catch(Exception ex){
			System.out.print("SqlProduct.SqlProduct"+ ex.getMessage());
		}
		return list;
		
	}
	
	public ArrayList<Product> searchProductbyName(String name){
		ArrayList<Product> list = new ArrayList<Product>();
		try{
			Statement stm = con.createStatement();
			String sql = "select * from product where product_name like  '%"+ name + "%'";
			System.out.println("sql == " + sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())	{
				Product product = new Product();
				product.setProduct_id(rs.getInt("product_id"));
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_amount(rs.getString("product_amount"));
				product.setProduct_price(rs.getString("product_price"));
//				product.setProduct_price(rs.getString("product_regdate"));
								
				list.add(product);				
				
			}
		}catch(Exception ex){
			System.out.print("SqlProduct.SqlProduct"+ ex.getMessage());
		}
		return list;
		
	}
	
	
	
	
	public ArrayList<Product> searchAll(){
		
		ArrayList<Product> list = new ArrayList<Product>();
		
		try{	
		    Statement stm = con.createStatement();
			String sql = "select * from product ";
			ResultSet rs = stm.executeQuery(sql);
			
		while(rs.next())	{
			Product product = new Product();
			
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_amount(rs.getString("product_amount"));
			product.setProduct_price(rs.getString("product_price"));
			System.out.print(product.getProduct_name());
			System.out.println(product.getProduct_id());
			
			list.add(product);		
			System.out.println("size == "+list.size());
			
		}
		
		}catch(SQLException ex){
		
			System.out.println("SqlProduct:searchAll:err:"+ex.getErrorCode() +": "+ex.getMessage());
		
		}
		return list;
		
	}
	
	public void insertproduct(Product product){
		
		try{

			
			Statement stm = con.createStatement();
			String sql = "insert into product (product_id,product_name,product_amount,product_price, product_regdate) "+" values (?,?,?,?,?)"; 
		
			PreparedStatement preparedStmt = con.prepareStatement(sql);
		    preparedStmt.setInt (1, product.getProduct_id());
		    preparedStmt.setString (2, product.getProduct_name());
		    preparedStmt.setString (3, product.getProduct_amount());		     	     
		   		     
		    preparedStmt.setString    (4, product.getProduct_price());
		    preparedStmt.setString   (5, product.getProduct_regdate());
		 
		      
		    preparedStmt.execute();
		       
		
			
		}catch(Exception ex){
			
			System.out.println("SqlProduct:searchAll:err:"+ex.getMessage());
		
		}
		
	}
	

	
	public void deleteproduct(String product){
		
		  String sql = "delete from product "		  		     	     
				     + "where product_id = ?";
	    try{  
	      PreparedStatement preparedStmt = con.prepareStatement(sql);
	      preparedStmt.setString(1, product);
	 
	     
	      preparedStmt.execute();
      }catch(Exception ex){
			
			System.out.println("SqlProduct:updateProduct:err:"+ex.getMessage());
		
		} 
	}
	public static void main(String[] args){
		
		
	}
}