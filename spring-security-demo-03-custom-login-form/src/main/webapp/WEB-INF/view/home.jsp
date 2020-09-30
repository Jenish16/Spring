<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Wizarding World</title>
</head>
<body>
	<h2>Wizarding World Home Page</h2>
	<hr>
	<h2>Hey Welcome to Wizarding World</h2>
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>
</html>