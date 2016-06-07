<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
if(session.getAttribute( "username" )==""||session.getAttribute( "username" )==null)
{
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
<title>What Spec? | Administration Page</title>
</head>
<body>
 <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./MainAdmin.jsp">What Spec? | Administrator Page</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
           <li><a href="./SearchProduct.jsp">จัดการสินค้า <span class="glyphicon glyphicon-list-alt"></span></a></li>
        <li><a href="./UserManagement.jsp">จัดการผู้ใช้ <span class="glyphicon glyphicon-user"></span></a></li> 
        <li><a href="./OrderManagement.jsp">จัดการคำสั่งซื้อ <span class="glyphicon glyphicon-shopping-cart"></span></a></li>
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
          
           <li><a href="#">Welcome <%= session.getAttribute( "username" ) %> <span class="glyphicon glyphicon-user"></span></a></li>
          <li><a href="./Logout.jsp">Logout <span class="glyphicon glyphicon-off"></span></a></li>
        </ul>
          
          
        </div>
      </div>
    </nav>
    
    
   <div class="container-fluid text-center">    
  	<div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left"> 
     <div class="container">
  		<div class="jumbotron text-center">
  			
  			<img src="./picture/what-spec-logo.jpg" align="center" width="100%" class="img-thumbnail"  alt="logo">
    		 
    
  		</div>
   
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