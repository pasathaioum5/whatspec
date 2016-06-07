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
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
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
		 ArrayList<Product> list = new ArrayList<Product>();
			String product_id = request.getParameter("product_id");
			String product_name = request.getParameter("product_name");
			String product_amount  = request.getParameter("product_amount");
			String product_price = request.getParameter("product_price");		
			String product_regdate = request.getParameter("product_regdate");
			
			System.out.println(product_id+"--"+product_name+"--"+product_amount+"--"+product_price+"--"+product_regdate);
			
			Product product = new Product();
			product.setProduct_id(Integer.parseInt(product_id));
			product.setProduct_name(product_name);
			product.setProduct_amount(product_amount);
			product.setProduct_price(product_price);
			product.setProduct_regdate(product_regdate);
			
			SqlProduct productAdd = new SqlProduct();  
			try{
				productAdd.insertproduct(product);
				
			}catch(Exception ex){
				request.setAttribute("errorMessege", ex.getMessage());
			}finally{
				list = productAdd.searchAll();
				request.setAttribute("productList", list); 
				RequestDispatcher dispatcher = request.getRequestDispatcher("./SearchProduct.jsp"); 
				dispatcher.forward(request, response);
			}
	}

}
