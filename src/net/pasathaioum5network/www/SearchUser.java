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
 * Servlet implementation class SearchUser
 */
@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUser() {
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
		 String searchOpt = request.getParameter("srchList");
		 String searchtxt = request.getParameter("srchtxt");
		 SqlUser user = new SqlUser();   
		 ArrayList<User> list = new ArrayList<User>(); 
		 
		 if(searchtxt==null || searchtxt.trim().equals("")){
			 list = user.searchAll(); 
		 }
		 else if (searchtxt != null){
			 System.out.println("earchOpt = " + searchOpt);
			 list = user.searchUserbyName(searchtxt);
		 }
//		 else{
//			 System.out.println("earchOpt = " + searchOpt);
//			 list = product.searchProductbyID(searchtxt);
//		 }
		
		 request.setAttribute("userList", list);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("./UserManagement.jsp");
		 dispatcher.forward(request, response);
		
		 
	}
	

}
