<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="net.pasathaioum5network.www.*" %>
<%
if(session.getAttribute( "username" )==""||session.getAttribute( "username" )==null){
	out.print("<HTML> <meta http-equiv='Refresh' content='0;url=Login.jsp' /><body></body></html>");
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="css/bootstrap.min.css" rel="stylesheet">

<title>Manage User</title>

  
</head>
<body>

  <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./UserManagement.jsp">What Spec? | User Management</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
            <li><a href="./AddUser.jsp">Add New User <span class="glyphicon glyphicon-file"></span></a><li>
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="./MainAdmin.jsp">Back to Previous Page <span class="glyphicon glyphicon-log-out"></span></a></li>
        </ul>
          
          <form class="navbar-form navbar-right" name="form1" action="/Whatspec/SearchUser" method="post">     
         
           <input type="text" name="srchtxt" class="form-control" placeholder="ค้นหาผู้ใช้...">
           <button type="submit" class="btn btn-success" >Search</button>
          </form>
        </div>
      </div>
    </nav>
   
   
   
   
   
  <div class="container">
  <h2>User List</h2>
      
  <table class="table table-striped">
    <thead>
      <tr>
        <th>User ID</th>
        <th>Username</th>
        <th>Password</th>
       
       
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
    
    <tbody>

   	  <c:forEach items="${requestScope.userList}" var="userList">
      <tr>
            <td><c:out value="${userList.user_id}"></c:out></td>
			<td><c:out value="${userList.username}"></c:out></td>
			<td><c:out value="${userList.password}"></c:out></td>
			
			
			<td><a href="/Whatspec/PreEditUser?uid=${userList.user_id}"><button type="button" class="btn btn-default">Edit <span class="glyphicon glyphicon-edit"></span></button></td>
			<td><a href="/Whatspec/DeleteUser?uid=${userList.user_id}"><button type="button" class="btn btn-default">Delete <span class="glyphicon glyphicon-remove"></span></button></td>
			
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