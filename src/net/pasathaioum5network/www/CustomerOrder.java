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
 * Servlet implementation class CustomerOrder
 */
@WebServlet("/CustomerOrder")
public class CustomerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement stmt;  
		Connection con;
		
    	
		String customer_name = request.getParameter("customer_name");
		String product_name = request.getParameter("product_name");
		String product_amount = request.getParameter("product_amount");
		String telephone = request.getParameter("telephone");
	
		
		
		
	
	   
	    try{
	    	String url = "jdbc:mysql://localhost:3306/whatspec";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root"); 
			stmt = con.createStatement();
			String QueryString = "";

			QueryString = "insert into whatspec.order (customer_name, product_name, product_amount, telephone) values ('"+customer_name+"','"+product_name+"','"+product_amount+"','"+telephone+"')";
		            
			stmt.executeUpdate(QueryString);
			
			
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
	    finally{
	    	
		
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher("./OrderComplete.jsp"); 
				dispatcher.forward(request, response);
				
			}
	}

}
