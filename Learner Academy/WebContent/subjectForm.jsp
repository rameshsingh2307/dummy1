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
<form action="createSubject" method="post">
<table border="1" cellpadding = "5" cellspacing = "5" align="center">
<tr><td colspan="2" align="center">Add subject form</td></tr>
<tr><td>Subject Name</td><td><input type="text" name="subjectName" placeholder="Subject name" required="required"></td></tr>
<tr><td>Subject Auther</td><td><input type="text" name="subjectAuther" placeholder="Subject auther" required="required"></td></tr>
<tr><td>Subject Details</td><td><textarea name="subjectDetail" rows="2" cols="25" placeholder="Enter text here..." required="required"></textarea></td></tr>

<tr>
<td>Select class</td>
<td>
	<select name=classes>		
	    <c:forEach items="${classList}" var="classes">	    	
	        <option value="${classes.classId}">${classes.className}</option>
	    </c:forEach>
	</select>
</td></tr>
<tr>

<tr><td colspan="2" align="center"><button type="submit">Add subject</button></td></tr>
</table>

</form>
</body>
</html>