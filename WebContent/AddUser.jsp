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
<title>Add user</title>

</head>
<body>
 <nav class="navbar navbar-default">
      <div class="container-fluid">
        <div class="navbar-header">
          <a class="navbar-brand" href="./UserManagement.jsp">What Spec? | User Management</a>
        </div>
       
        <div >
        <ul class="nav navbar-nav">
           
        </ul>
        
        
        <ul class="nav navbar-nav navbar-right">
            <li><a href="./UserManagement.jsp">Back to Previous Page <span class="glyphicon glyphicon-log-out"></span></a></li>
        </ul>
          
          
        </div>
      </div>
    </nav>
    
    
    <div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
     
    </div>
    <div class="col-sm-8 text-left"> 
     <form role="form" id="addUserForm" action="/Whatspec/CreateUser" method="post">
    <div class="form-group">
      <label for="username">Username:</label>
      <input type="text" class="form-control" name="username" id="username" placeholder="Please Enter Username">
    </div>
     <div class="form-group">
      <label for="password">Password:</label>
      <input type="text" class="form-control" name="password"  id="password" placeholder="Please Enter Password">
    </div> 
    <button type="submit" class="btn btn-default">Submit <span class="glyphicon glyphicon-ok"></span></button>
  </form>
  <script>
  $().ready(function() {

    jQuery.validator.setDefaults({
      success: "valid"
    });
    $( "#addUserForm" ).validate({
      rules: {
        
        username: "required",
        password: "required",
       
      }
      ,
      messages: {
        username: "กรุณากรอกชื่อผู้ใช้",
        password: "กรุณากรอกรหัสผ่าน"
   
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