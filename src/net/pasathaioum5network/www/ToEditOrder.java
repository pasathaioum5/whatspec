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
 * Servlet implementation class ToEditOrder
 */
@WebServlet("/ToEditOrder")
public class ToEditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToEditOrder() {
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
		String uid = request.getParameter("uid");
    	
		String order_id = request.getParameter("order_id");
		String customer_name = request.getParameter("customer_name");
		String product_name = request.getParameter("product_name");
		String product_amount = request.getParameter("product_amount");
		String telephone = request.getParameter("telephone");
		
	
		 SqlOrder order = new SqlOrder();   
		 ArrayList<Order> list = new ArrayList<Order>();
		
		
	
	   
	    try{
	    	String url = "jdbc:mysql://localhost:3306/whatspec";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root"); 
			stmt = con.createStatement();
			String QueryString = "";

			QueryString = "update whatspec.order set order_id = '"+order_id+"',customer_name = '"+customer_name+"',product_name = '"+product_name+"',product_amount = '"+product_amount+"',telephone = '"+telephone+"' where order_id = '"+uid+"'";
			stmt.executeUpdate(QueryString);
			System.out.println(QueryString);
			
	    } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally{
	    	list = order.searchAll();
			request.setAttribute("orderList", list); 
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher("./OrderManagement.jsp"); 
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
