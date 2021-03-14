<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<form action="displayRepoprt" method="post">
		<table border="1" cellpadding = "5" cellspacing = "5" align="center">
			<tr><td colspan="2" align="center">Select class to view report</td></tr>			
			
			<tr><td>Select class</td><td>
				<select name="classes">
				    <c:forEach items="${classesList}" var="classes">
				    	<%-- <option value="" selected disabled hidden>Choose here</option>--%>
				        <option value="${classes.classId}">${classes.className}</option>
				    </c:forEach>
				</select>
			</td></tr>			
			<tr><td colspan="2" align="center"><button type="submit">Submit</button></td></tr>
		</table>	
	</form>
</body>
</html>