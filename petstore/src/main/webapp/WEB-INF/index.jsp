<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pet Shelter</title>
</head>
<body>
	<header>
		<h1>Spring Data I.  All pets shown</h1>
		<h3><c:out value='${ allPets }'/> </h3>
	</header>
	<main>
	<a href="/pets/add">Add Pet</a>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<c:forEach items='${ allPets }' var='pet' >
			<tr>
				<td><h3> <a href="/pets/${pet.id}">${ pet.name }</a></h3></td>
				<td><h3>${ pet.age }</h3></td>
				<td><h3>${ pet.description }</h3></td>
				<td> <a href="/pets/${ pet.id }" > View </a> | <a href="/pets/${ pet.id }/edit" > Update </a>  | <a href="/pets/${ pet.id }/delete" > Delete </a></td>
			</tr>
		</c:forEach>
	</table>
	
	</main>
</body>
</html>