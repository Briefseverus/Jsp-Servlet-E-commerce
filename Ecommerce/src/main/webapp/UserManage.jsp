<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of Product</title>
<!-- Include Bootstrap 4 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
/* Fix navbar to top */
body {
	padding-top: 70px;
}

.navbar.fixed-top {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	z-index: 1030;
}

/* Logout button */
.logout-btn {
	color: #fff;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<a class="navbar-brand" href="#"> Management System</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="UserManage">User
						Management</a></li>
				<li class="nav-item"><a class="nav-link" href="OrderManage">Order
						Management</a></li>
			</ul>
		</div>
		<div class="ml-auto">
			<a href="logout" class="btn btn-outline-light logout-btn">Logout</a>
		</div>
	</nav>
	<div class="container mt-5">


		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>User ID</th>
					<th>Role ID</th>
					<th>Username</th>
					<th>Password</th>
					<th>Full name</th>
					<th>Email</th>
					<th>Phone number</th>
					<th>Activated</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${pros}">
					<tr>
						<td>${pro.getUser_id()}</td>
						<td>${pro.role_id}</td>
						<td>${pro.getUsername()}</td>
						<td>${pro.getPassword()}</td>
						<td>${pro.getFull_name()}</td>
						<td>${pro.getEmail()}</td>
						<td>${pro.getPhone_number()}</td>
						<td>${pro.activated}</td>


					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- Include Bootstrap 4 JavaScript and jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script>
		
	</script>
</body>
</html>
