<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Change This</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
	<h1>Dojo Info</h1>
	<div class="container">
	<br/>
	<a href="/">Home</a>
	<h3>${ dojo.name }</h3>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>

			<c:forEach items="${ dojo.ninjas }" var="ninja">
				<tr>
					<td>${ ninja.firstName } </td>
					<td>${ ninja.lastName } </td>
					<td>${ ninja.age } </td>
				</tr>			
			</c:forEach>
				
			</tbody>
		</table>
		
		<form action="/${ id }/delete" method="post" >
			<input type="hidden" name="_method" value="delete">
			<input type="submit" value="Delete">
		</form>
	</div>
</div>
</body>
</html>