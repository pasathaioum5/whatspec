package net.pasathaioum5network.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToEditUser
 */
@WebServlet("/ToEditUser")
public class ToEditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToEditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement stmt;  
		Connection con;
		String uid=request.getParameter("uid");
    	
		String username=request.getParameter("username");
		String password=request.getParameter("password");
	
		SqlUser user = new SqlUser();   
		 ArrayList<User> list = new ArrayList<User>();
		
		
	
	   
	    try{
	    	String url = "jdbc:mysql://localhost:3306/whatspec";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root"); 
			stmt = con.createStatement();
			String QueryString = "";

			QueryString = "update user set username = '"+username+"',password = '"+password+"' where user_id = '"+uid+"'";
			stmt.executeUpdate(QueryString);
			
			
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally{
	    	list = user.searchAll();
			request.setAttribute("userList", list); 
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher("./UserManagement.jsp"); 
				dispatcher.forward(request, response);
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
