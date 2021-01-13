
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #335588">
			<div>
				<a href="/TodoWeb/index.jsp" class="navbar-brand">
					<h2 style="color: white">Todo App</h2>
				</a>
			</div>
		</nav>
	</header>
	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Todos</h3>
			<hr>
			<div class="container text-left">

				<a href="/TodoWeb/add.jsp" class="btn btn-success">Add Todo</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Index</th>
						<th>Todo</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				<%= request.getAttribute("listTodo") %>
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>