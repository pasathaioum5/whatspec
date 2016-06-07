package net.pasathaioum5network.www;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EditedServlet
 */
@WebServlet("/ToEditServlet")
public class ToEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToEditServlet() {
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
    	String product_id=request.getParameter("product_id");
		String product_name=request.getParameter("product_name");
		String product_amount=request.getParameter("product_amount");
		String product_price=request.getParameter("product_price");
		SqlProduct product = new SqlProduct();   
		 ArrayList<Product> list = new ArrayList<Product>();
		
		
	
	   
	    try{
	    	String url = "jdbc:mysql://localhost:3306/whatspec";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root"); 
			stmt = con.createStatement();
			String QueryString = "";

			QueryString = "update product set product_id = '"+product_id+"',product_name = '"+product_name+"', product_amount = '"+product_amount+"', product_price = '"+product_price+"' where product_id = '"+uid+"'";
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
	    	list = product.searchAll();
			request.setAttribute("productList", list); 
	    	  RequestDispatcher dispatcher1 = request.getRequestDispatcher("./SearchProduct.jsp"); 
				dispatcher1.forward(request, response);
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
