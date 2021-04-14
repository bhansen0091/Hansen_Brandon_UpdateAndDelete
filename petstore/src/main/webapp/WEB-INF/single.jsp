<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Single Pet</title>
</head>
<body>
	<header>
		<h1>Single Pet</h1>
	</header>
	<main>
	<br/>
		<h3>Show info about ${ sPet.name }</h3>
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${ sPet.name } </td>
					<td>${ sPet.description } </td>
					<td>${ sPet.age } </td>
				</tr>
			</tbody>
		</table>
		
		<form action="/pets/${ id }/delete" method="post" >
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
		<h3> <a href="/pets/${sPet.id }/edit">Edit</a></h3>
	</main>
</body>
</html>