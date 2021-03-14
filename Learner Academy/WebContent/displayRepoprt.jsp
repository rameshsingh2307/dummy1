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
	<div align="center">
		<table border="2" cellpadding="5"> 
		<tr><td bgcolor="#33ADFF"><h2>Class report</h2></td></tr>
		</table>
        <table border="1" cellpadding="5">            
            <tr>
                <th bgcolor="#33ADFF">Subject Name</th>                                        
            </tr>
           	<c:forEach var="subject" items="${subjectList}">
                <tr>                    
                    <td><c:out value="${subject.subjectName}" /></td>                   
                </tr>
            </c:forEach>   
        </table>
        <br/>
        
        <table border="1" cellpadding="5">         
            <tr>                
                <th bgcolor="#33ADFF">Teacher Name</th>                         
            </tr>
            <c:forEach var="teacher" items="${teacherList}">
                <tr>                    
                    <td><c:out value="${teacher.teacherName}" /></td>                   
                </tr>
            </c:forEach>
        </table>
        
        <br/>
        
        <table border="1" cellpadding="5">         
            <tr>                
                <th bgcolor="#33ADFF">Student Name</th>                         
            </tr>
            <c:forEach var="student" items="${studentList}">
                <tr>                    
                    <td><c:out value="${student.studentName}" /></td>                   
                </tr>
            </c:forEach>
        </table>
    </div>
    <table border="1" cellpadding = "5" cellspacing = "5" align="center">
	 <tr><td><a href="MainPage.jsp"><b>Main page</b></a></td></tr>
	 </table>	
</body>
</html>