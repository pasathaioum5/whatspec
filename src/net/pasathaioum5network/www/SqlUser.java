package net.pasathaioum5network.www;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlUser {
	Connection con = DBConnect.connectToDB();

	public ArrayList<User> searchAll(){

		ArrayList<User> list = new ArrayList<User>();

		try{	
			Statement stm = con.createStatement();
			String sql = "select * from user ";
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next())	{
				User user = new User();

				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

				

				list.add(user);		
				System.out.println("size == "+list.size());

			}

		}catch(SQLException ex){

			System.out.println("Function searchAll in SqlUser fail to complete"+ex.getErrorCode() +": "+ex.getMessage());

		}
		return list;

	}
	public void insertuser(User user){

		try{
			
			Statement stm = con.createStatement();
			String sql = "insert into user (username, password)  "
					+" values (?,?)"; 

			PreparedStatement preparedStmt = con.prepareStatement(sql);
				     	     

			preparedStmt.setString    (1, user.getUsername());
			preparedStmt.setString   (2, user.getPassword());


			preparedStmt.execute();



		}catch(Exception ex){

			System.out.println("Function insertuser in SqlUser fail to complete"+ex.getMessage());

		}

	}
	public ArrayList<User> searchUserbyName(String name){
		ArrayList<User> list = new ArrayList<User>();
		try{
			Statement stm = con.createStatement();
			String sql = "select * from user where username like  '%"+ name + "%'";
			System.out.println("sql == " + sql);
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next())	{
				User user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));

								
				list.add(user);				
				
			}
		}catch(Exception ex){
			System.out.print("Function searchUserbyName in SqlUser fail to complete"+ ex.getMessage());
		}
		return list;
		
	}
	public void deleteuser(String user){
		
		  String sql = "delete from user "		  		     	     
				     + "where user_id = ?";
	    try{  
	      PreparedStatement preparedStmt = con.prepareStatement(sql);
	      preparedStmt.setString(1, user);
	 
	     
	      preparedStmt.execute();
    }catch(Exception ex){
			
			System.out.println("SqlProduct:updateProduct:err:"+ex.getMessage());
		
		} 
	}
}
