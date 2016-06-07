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
 * Servlet implementation class SearchOrder
 */
@WebServlet("/SearchOrder")
public class SearchOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrder() {
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
		 SqlOrder order = new SqlOrder();   
		 ArrayList<Order> list = new ArrayList<Order>(); 
		 
		 if(searchtxt==null || searchtxt.trim().equals("")){
			 list = order.searchAll(); 
		 }else if (searchOpt.equals("2")){
			 System.out.println("earchOpt = " + searchOpt);
			 list = order.searchOrderbyName(searchtxt);
		 }else{
			 System.out.println("earchOpt = " + searchOpt);
			 list = order.searchOrderbyID(searchtxt);
		 }
		
		 request.setAttribute("orderList", list);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("./OrderManagement.jsp");
		 dispatcher.forward(request, response);
		
		 	
	}

}
