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
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Description</th>
					<th>Price</th>
					<th>Quantity</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${pros}">
					<tr>
						<td>${pro.getProduct_id()}</td>
						<td>${pro.getProduct_name()}</td>
						<td>${pro.getDescripton()}</td>
						<td>${pro.getPrice()}</td>
						<td>${pro.getQuantity()}</td>
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
