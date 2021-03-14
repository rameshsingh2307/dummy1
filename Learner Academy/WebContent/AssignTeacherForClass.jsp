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

<form action="assingTeacherToClass" method="post">
	<table border="1" cellpadding = "5" cellspacing = "5" align="center">	
	<tr>
	<td>Select Teacher</td>
	<td>
		<select name="teachers" required="required">		
		    <c:forEach items="${teacherList}" var="teachers">	    	
		        <option value="${teachers.teacherId}">${teachers.teacherName}</option>
		    </c:forEach>
		</select>
	</td></tr>
	<tr>
	<tr>
	<td>Select Classes to assign</td>
	<td>
		<select name="classes" required="required" multiple="multiple">		
		    <c:forEach items="${classesList}" var="classes">	    	
		        <option value="${classes.classId}">${classes.className}</option>
		    </c:forEach>
		</select>
	</td></tr>
	<tr>
	<tr><td colspan="2" align="center"><button type="submit">Submit</button></td></tr>
	</table>
	<table border="1" cellpadding = "5" cellspacing = "5" align="center">
	 <tr><td><a href="MainPage.jsp"><b>Main page</b></a></td></tr>
	 </table>
</form>

</body>
</html>