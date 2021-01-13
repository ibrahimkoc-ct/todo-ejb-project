<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="container">
				<h3 class="text-center">Update Todo</h3>
				<hr>
				<div class="container text-left">

					<form method="put" action="todo">
					<fieldset class="form-group">
						<label>Id</label> <input type="text" class="form-control"
							name="id">
					</fieldset>
					<fieldset class="form-group">
						<label>Todo</label> <input type="text" class="form-control"
							name="description">
					</fieldset>
					<input type="submit" class="btn btn-success" value="Add">
					<hr>
					</form>
				</div>
			</div>
</body>
</html>