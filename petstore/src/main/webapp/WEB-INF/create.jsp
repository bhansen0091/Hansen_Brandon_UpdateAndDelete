<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Pet</title>
</head>
<body>
	<header>
		<h1>Create Pet Form</h1>
	</header>
	<main>
		<form:form action="/pets/create" method="post" modelAttribute="pet" >
			<p>
				<form:label path="name">Name</form:label>
				<form:errors path="name"/>
				<form:input path="name"/>
			</p>
			
			<p>
				<form:label path="description">Description</form:label>
				<form:errors path="description"/>
				<form:input path="description" />
			</p>
			
			<p>
				<form:label path="age">Age</form:label>
				<form:errors path="age" />
				<form:input type="number" path="age"/>
			</p>
			<input type="submit"/>
		</form:form>
	
	</main>

</body>
</html>