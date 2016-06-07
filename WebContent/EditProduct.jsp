<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
if(session.getAttribute( "username" )==""||session.getAttribute( "username" )==null){
	out.print("<HTML> <meta http-equiv='Refresh' content='0;url=Login.jsp' /><body></body></html>");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="./js/jquery-1.11.3.min.js"></script>
<script src="./js/jquery.validate.min.js"></script>
<script src="./js/additional-methods.min.js"></script>
<title>Edit Product</title>

</head>
<body>
 <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./SearchProduct.jsp">What Spec? | Product Management</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
           
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="./SearchProduct.jsp">Back to Previous Page <span class="glyphicon glyphicon-log-out"></span></a></li>
        </ul>
          
          
        </div>
      </div>
    </nav>
    
    
    <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     
    </div>
    <div class="col-sm-8 text-left"> 
     <form role="form" id="editProductForm" action="/Whatspec/ToEditServlet" method="get">
    <div class="form-group">
      <label for="product_id">Product ID:</label>
      <input type="text" class="form-control" name="product_id" id="product_id" value="<%= request.getAttribute("product_id")%>"/>
    </div>
     <div class="form-group">
      <label for="product_name">Product Name:</label>
      <input type="text" class="form-control" name="product_name"  id="product_name" value="<%= request.getAttribute("product_name")%>"/>
    </div> <div class="form-group">
      <label for="product_amount">Product Amount:</label>
      <input type="text" class="form-control" name="product_amount" id="product_amount" value="<%= request.getAttribute("product_amount")%>"/>
    </div> <div class="form-group">
      <label for="product_price">Product Price:</label>
      <input type="text" class="form-control" name="product_price" id="product_price" value="<%= request.getAttribute("product_price")%>"/>
    </div> 
    <input type="hidden" name="uid" id="uid" value="<%= request.getAttribute("product_id")%>" />
    <button type="submit" class="btn btn-default">Submit <span class="glyphicon glyphicon-ok"></span></button>
  </form>
  <script>
  $().ready(function() {

    jQuery.validator.setDefaults({
      success: "valid"
    });
    $( "#editProductForm" ).validate({
      rules: {
        
        product_id: "required",
        product_name: "required",
        
        product_amount: {
        	required: true,
        	number: true
        	
        },
        
        product_price: {
        	required: true,
        	number: true
        	
        }
      
      }
      ,
      messages: {
    	  product_id: "กรุณาระบุรหัสสินค้า",
          product_name: "กรุณาระบุชื่อสินค้า",
          
          product_amount: {
        	required: "กรุณาระบุจำนวนสินค้า",
        	number: "กรุณากรอกเป็นตัวเลข"
        },
        
          product_price: {
        	required: "กรุณาระบุจำนวนสินค้า",
        	number: "กรุณากรอกเป็นตัวเลข"
        	
        }
         
   
      }
    });
  });

</script>
    </div>
    <div class="col-sm-2 sidenav">
     
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Copyright by Madolche Group</p>
</footer>
</body>
</html>