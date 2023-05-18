<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ecommerce.com.daos.UserDao"%>
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
					<th>Order ID</th>
					<th>User ID</th>
					<th>Date</th>
					<th>Status</th>
					<th>User Name</th>
					<th>Full Name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${pros}">
					<tr>
						<td>${pro.getOrder_id()}</td>
						<td>${pro.getUser_id()}</td>
						<td>${pro.getOrder_date()}</td>
						<td>${pro.getOrder_status()}</td>
						<td><c:set var="user"
								value="${UserDao.getuserById(pro.getUser_id())}" /> <c:if
								test="${user != null}">
                ${user.getUsername()}
            </c:if></td>
            <td><c:set var="user"
								value="${UserDao.getuserById(pro.getUser_id())}" /> <c:if
								test="${user != null}">
                ${user.getFull_name()}
            </c:if></td>
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
