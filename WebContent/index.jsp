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

<title>What Spec? | Store Page</title>

</head>
<%
	
%>
<body>
 <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./index.jsp">What Spec? | Store Page</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
           
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="./Login.jsp">Admin Login <span class="glyphicon glyphicon-log-in"></span></a></li>
        </ul>
          
          
        </div>
      </div>
    </nav>
    
    
    <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     
    </div>
    <div class="col-sm-8 text-center"> 
	    <div class="container">
	  		<div class="jumbotron text-center">
	  			
	  			<img src="./picture/what-spec-logo.jpg" align="center" width="100%" class="img-thumbnail"  alt="logo">
	    		
	  		</div>
	  		<form role="form" name="form1" action="/Whatspec/SearchServlet2" method="post">
	  		 <button type="submit" class="btn btn-primary">Order <span class="glyphicon glyphicon-shopping-cart"></span></button>
	  		 </form>
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