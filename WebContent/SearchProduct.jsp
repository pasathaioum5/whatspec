<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
if(session.getAttribute( "username" )==""||session.getAttribute( "username" )==null){
	out.print("<HTML> <meta http-equiv='Refresh' content='0;url=Login.jsp' /><body></body></html>");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import = "net.pasathaioum5network.www.Product,
				   java.util.ArrayList" %>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="./js/jquery-1.11.3.min.js"></script>
<script src="./js/jquery.validate.min.js"></script>
<script src="./js/additional-methods.min.js"></script>
<title>Product Management</title>

  
</head>
<body>
  <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./SearchProduct.jsp">What Spec? | Product Management</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
            <li><a href="./AddProduct.jsp">Add New Product <span class="glyphicon glyphicon-file"></span></a><li>
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="./MainAdmin.jsp">Back to Previous Page <span class="glyphicon glyphicon-log-out"></span></a></li>
        </ul>
          
          <form class="navbar-form navbar-right" name="form1" action="/Whatspec/SearchServlet" method="post">     
         <select class="form-control" name="srchList">
    		<option value="1">Search by Product Name</option>
    		<option value="2">Search by Product ID</option>
    
  		</select>
           <input type="text" name="srchtxt" class="form-control" placeholder="ค้นหา...">
           <button type="submit" class="btn btn-success">Search</button>
          </form>
        </div>
      </div>
    </nav>
   
   
   
   
   
  <div class="container">
  <h2>Product List</h2>
      
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Product Amount</th>
        <th>Product Price</th>
       
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    
    <tbody>
   	  <c:forEach items="${requestScope.productList}" var="productList">
      <tr>
            <td><c:out value="${productList.product_id}"></c:out></td>
			<td><c:out value="${productList.product_name}"></c:out></td>
			<td><c:out value="${productList.product_amount}"></c:out></td>
			<td><c:out value="${productList.product_price}"></c:out></td>
			
			<td><a href="/Whatspec/PreEditServlet?uid=${productList.product_id}"><button type="button" class="btn btn-default">Edit <span class="glyphicon glyphicon-edit"></span></button></td>
			<td><a href="/Whatspec/DeleteServlet?uid=${productList.product_id}"><button type="button" class="btn btn-default">Delete <span class="glyphicon glyphicon-remove"></span></button></td>
			
      </tr>
      </c:forEach>
    </tbody>
  </table>
</div>














<footer class="container-fluid text-center">
  <p>Copyright by Madolche Group</p>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>