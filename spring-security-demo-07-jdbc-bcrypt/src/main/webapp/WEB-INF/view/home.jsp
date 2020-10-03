<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
	
		<p>
			User : <security:authentication property="principal.username"/>
		</p>
		<br><br>
		<p>
			Role(s) : <security:authentication property="principal.authorities"/>
		</p>
	
	<hr>
	
	<!-- Add a link to point to /leaders ... this is for the managers -->
	<security:authorize access="hasRole('MANAGER')">
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>
			(Only for Manager peeps)
		</p>
	</security:authorize>
	<!-- Add a link to point to /systems ... this is for the admins -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
		</p>
	
	</security:authorize>
	<hr>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>
</html>