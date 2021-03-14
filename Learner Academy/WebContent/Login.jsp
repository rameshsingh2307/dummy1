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
<form action="loginCheck" method="post">
<table border="1" cellpadding = "5" cellspacing = "5" align="center">
	<tr><td colspan="2" align="center"><b><font color="red">Login page..</font></b></td></tr>
  	<tr><td>Enter Login Id</td><td><input type="text" id="loginId" placeholder="login Id" name="loginId"></td></tr>
    <tr><td>Password</td><td><input type="password" id="password" placeholder="password" name="password"></td></tr>
  	<tr><td colspan="2" align="center"><button type="submit">Login in</button></td></tr>
  </table>
  <table border="1" cellpadding = "5" cellspacing = "5" align="center">
  <tr><td><a href="new"><b>Register User</b></a></td></tr>
  </table>
</form> 

</body>
</html>