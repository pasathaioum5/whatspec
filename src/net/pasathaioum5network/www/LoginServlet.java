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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		HttpSession session = request.getSession(true);
		String dataget1 = request.getParameter("username");
		String dataget2 = request.getParameter("password");
		Statement stmt;  
		Connection con;
		try { 
			String url = "jdbc:mysql://localhost:3306/whatspec";
		    Class.forName("com.mysql.jdbc.Driver");
		    con = DriverManager.getConnection(url, "root", "root"); 
			stmt = con.createStatement();
			
			String QueryString = "select * from user where username='"+dataget1+"' and password='"+dataget2+"'";

			ResultSet rs = stmt.executeQuery(QueryString);
			   if(rs.next()){
				session.setAttribute( "username", rs.getString(2));
				session.setAttribute( "password", rs.getString(3));
			   }
			  
		   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally{
	    	  RequestDispatcher dispatcher = request.getRequestDispatcher("./MainAdmin.jsp");
				dispatcher.forward(request, response);
		}
		
	}

}
