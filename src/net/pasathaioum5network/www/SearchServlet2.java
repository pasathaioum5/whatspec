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
 * Servlet implementation class SearchServlet2
 */
@WebServlet("/SearchServlet2")
public class SearchServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet2() {
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
		 SqlProduct product = new SqlProduct();   
		 ArrayList<Product> list = new ArrayList<Product>(); 
		 
		 if(searchtxt==null || searchtxt.trim().equals("")){
			 list = product.searchAll(); 
		 }else if (searchOpt.equals("1")){
			 System.out.println("earchOpt = " + searchOpt);
			 list = product.searchProductbyName(searchtxt);
		 }else{
			 System.out.println("earchOpt = " + searchOpt);
			 list = product.searchProductbyID(searchtxt);
		 }
		
		 request.setAttribute("productList", list);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("./Order.jsp");
		 dispatcher.forward(request, response);
		
		 
	
	}

}
