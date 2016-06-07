package net.pasathaioum5network.www;


import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
	
	public  static Connection connectToDB(){
		String host ="jdbc:mysql://localhost:3306/whatspec";
		String user = "root";
		String password ="root";
		
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");	
			con = DriverManager.getConnection(host,user,password);
		
			if(con != null){
	           System.out.println("Database Connected.");
			} else {
			   System.out.println("Database Connect Failed.");
			}
		
		
		}catch(Exception ex){
			System.out.println("DBConnect err:"+ex.getMessage());
		}
		return con;
		
		
	}
	
	


}
