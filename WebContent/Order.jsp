<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="./css/bootstrap.min.css" rel="stylesheet">
<script src="./js/jquery-1.11.3.min.js"></script>
<script src="./js/jquery.validate.min.js"></script>
<script src="./js/additional-methods.min.js"></script>
<script src="./js/carousel.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>What Spec? | Order Page</title>

</head>

<body>
 <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./index.jsp">What Spec? | Order Page</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
           
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="./index.jsp">Back to Previous Page <span class="glyphicon glyphicon-log-out"></span></a></li>
        </ul>
          
          
        </div>
      </div>
    </nav>
    
    
    <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     
    </div>
    <div class="col-sm-8 text-left"> 
	    
	   <form role="form" id="customerForm" action="/Whatspec/CustomerOrder" method="post">
    <div class="form-group">
      <label for="customer_name">Customer Name:</label>
      <input type="text" class="form-control" name="customer_name" id="customer_name" placeholder="Please Enter Customer Name">
    </div>
    
     <div class="form-group">
     
	  	<label for="product_name">Product Name:</label>
	  
	  
	  	<select class="form-control" id="product_name" name="product_name">
	  		<c:forEach items="${requestScope.productList}" var="productList">
		    <option><c:out value="${productList.product_name}"></c:out></option>
		    </c:forEach>
  		</select>
  		
	</div>

	<div class="form-group">
      <label for="product_amount">Product Amount:</label>
      <input type="text" class="form-control" name="product_amount" id="product_amount" placeholder="Please Enter Product Amount">
    </div> 
    
    <div class="form-group">
      <label for="telephone">หมายเลขโทรศัพท์ (สำหรับเจ้าหน้าที่ติดต่อกลับ):</label>
      <input type="text" class="form-control" name="telephone" id="telephone" placeholder="Please Enter Telephone Number">
    </div> 
    <button type="submit" class="btn btn-default">Submit <span class="glyphicon glyphicon-ok"></span></button>
  		</form>
  		<script>
  $().ready(function() {

    jQuery.validator.setDefaults({
      success: "valid"
    });
    $( "#customerForm" ).validate({
      rules: {
        
        customer_name: "required",
        product_amount: {	
       		required: true,
       		number: true
       		},
       	
        telephone:{	
           	required: true,
           	minlength: 9,
            maxlength:10,
           	number: true
           	},
      }
      ,
      messages: {
    	  customer_name: "กรุณากรอกชื่อของลูกค้า",
          product_amount: {	
         		required: "กรุณากรอกจำนวนสินค้าที่ต้องการ",
           		number: "กรุณากรอกเป็นตัวเลข"
           		},
          telephone: {	
        	  required: "กรุณากรอกเบอร์ติดต่อกลับ",
        	  minlength: "หมายเลขโทรศัพท์ต้องไม่ต่ำกว่า 9 ตัวอักษร",
              maxlength: "หมายเลขโทรศัพท์ต้องไม่มากกว่า 10 ตัวอักษร",
         		number: "กรุณากรอกเป็นตัวเลข"
               	}
   
      }
    });
  });

</script>
		</div>
		

  
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