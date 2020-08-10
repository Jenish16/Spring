<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
		First Name : <form:input path = "firstName" />
		<br/><br/>
		Last Name : <form:input path = "lastName" />
		<br/><br/>
		Country : 
		<form:select path="country">
			<%-- <form:option value="India" label="India" />	
			<form:option value="Brazil" label="Brazil" />
			<form:option value="France" label="France" />
			<form:option value="Germany" label="Germany" />		 --%>
			<form:options items="${student.countryOptions}" />
		</form:select>
		<br/><br/>
		Favourite Language :
		Java <form:radiobutton path="favouriteLanguage" value="Java"/> 
		JavaScript <form:radiobutton path="favouriteLanguage" value="JavaScript"/> 
		Python <form:radiobutton path="favouriteLanguage" value="Python"/> 
	
		<br/><br/>
		Operating Systems : 
		Linux <form:checkbox path="operatingSystems" value="Linux"/>
		Mac <form:checkbox path="operatingSystems" value="Mac"/>
		Windows <form:checkbox path="operatingSystems" value="Windows"/>
		
		
		<br/><br/>
		<input type="submit" value="Submit"/>
		
	</form:form>
</body>
</html>