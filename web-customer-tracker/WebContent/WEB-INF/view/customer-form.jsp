<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Save Customer</title>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST"> 
			<form:hidden path="id"/>
			<table>
				<tbody>
					<tr>
						<td><lable>First Name:</lable></td>
						<td><form:input path="firstName"/><form:errors path="firstName" cssClass="error"/></td>
					</tr>
					<tr>
						<td><lable>Last Name:</lable></td>
						<td><form:input path="lastName"/><form:errors path="lastName" cssClass="error"/></td>
					</tr>
					<tr>
						<td><lable>E-mail:</lable></td>
						<td><form:input path="email"/><form:errors path="email" cssClass="error"/></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style="clear; both;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>