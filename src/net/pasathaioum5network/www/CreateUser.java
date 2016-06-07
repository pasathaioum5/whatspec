package net.pasathaioum5network.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUser
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
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
		 ArrayList<User> list = new ArrayList<User>();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			
//			System.out.println(product_id+"--"+product_name+"--"+product_amount+"--"+product_price+"--"+product_regdate);
			
			User user = new User();
			
			user.setUsername(username);
			user.setPassword(password);
			
			SqlUser AddUser = new SqlUser();  
			try{
				AddUser.insertuser(user);
				
			}catch(Exception ex){
				request.setAttribute("errorMessege", ex.getMessage());
			}finally{
				list = AddUser.searchAll();
				request.setAttribute("userList", list); 
				RequestDispatcher dispatcher = request.getRequestDispatcher("./UserManagement.jsp"); 
				dispatcher.forward(request, response);
			}
	}

}
