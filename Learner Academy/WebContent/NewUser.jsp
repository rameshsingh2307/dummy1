<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="Login.css" rel="stylesheet">
</head>
<body>
<form action="CreateUser" method="post">
  <table border="1" cellpadding = "5" cellspacing = "5" align="center">
  	  <tr><td colspan="2" align="center">Add admin form</td></tr>
      <tr><td>Enter name</td><td><input type="text" id="name" placeholder="Enter name" name="name"></td></tr>
    
      <tr><td>Enter Login Id</td><td><input type="text" id="loginId" placeholder="Enter login Id" name="loginId"></td></tr>
   
      <tr><td>Password</td><td><input type="password" id="password" placeholder="Enter password" name="password"></td></tr>
   
      <tr><td>Role</td><td><select id="role" class="form-control" name="role">       
         <option value="admin">Admin</option>
		 <option value="user">User</option>		
      </select>
      </td></tr>
      <tr><td colspan="2" align="center"><button type="submit">Add user</button></td></tr>
  </table>  
  <table border="1" cellpadding = "5" cellspacing = "5" align="center">
  <tr><td><a href="login"><b>Login</b></a></td></tr>
  </table>
</form>
</body>
</html>