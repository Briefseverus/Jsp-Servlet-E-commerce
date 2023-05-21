<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of Product</title>
<!-- Include Bootstrap 4 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">


		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Order ID</th>
					<th>User ID</th>
					<th>Order Date</th>
					<th>Order Status</th>
					<th>View</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${pros}">
					<tr>
						<td>${pro.getOrder_id()}</td>
						<td>${pro.getUser_id()}</td>
						<td>${pro.getOrder_date()}</td>
						<td>${pro.getOrder_status()}</td>
						<td>
							<form method="post" action="OrderDisplay">
								<input type="hidden" name="orderid" value="${pro.getOrder_id()}">
								<input type="submit" value="View">
							</form>
						</td>
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
