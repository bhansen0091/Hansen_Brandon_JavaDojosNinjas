<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change This</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="my-2">
			<a href="/dojo/new" class="btn btn-success mr-3">Add Dojo</a> <a
				href="/ninja/new" class="btn btn-primary">Add Ninja</a>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Dojo</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${ allDojos }' var='dojo'>
					<tr>
						<td>
							<h5>
								<a href="/dojo/${dojo.id}">${ dojo.name}</a>
							</h5>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>