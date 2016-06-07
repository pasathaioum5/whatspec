package net.pasathaioum5network.www;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreEditOrder
 */
@WebServlet("/PreEditOrder")
public class PreEditOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreEditOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		Statement stmt;  Connection con;
	      
	      try { 
				String url = "jdbc:mysql://localhost:3306/whatspec";
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, "root", "root"); 
				stmt = con.createStatement();
				String QueryString = "SELECT * from whatspec.order where order_id = '"+uid+"'";
				ResultSet rs = stmt.executeQuery(QueryString);
				while(rs.next()){
					request.setAttribute("order_id", rs.getString("order_id"));
					request.setAttribute("customer_name", rs.getString("customer_name"));
					request.setAttribute("product_name", rs.getString("product_name"));
					request.setAttribute("product_amount", rs.getString("product_amount"));
					request.setAttribute("telephone", rs.getString("telephone"));
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      finally{
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher("./EditOrder.jsp");
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
