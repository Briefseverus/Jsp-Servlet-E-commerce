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

					<th>Product Name</th>
					<th>Quantity</th>
					<th>Thumbnail</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${cartItems}">
					<tr>
						<td>${pro.productName}</td>
						<td>${pro.quantity}</td>
						<td><img src="${pro.productImg}" alt="Mo ta anh" width="300"
							height="300"></td>
						<td>${pro.price}</td>


					</tr>
				
				</c:forEach>
					<p>${cart.getTotalPrice()}</p>
			</tbody>
		</table>
	</div>
	<!-- Include Bootstrap 4 JavaScript and jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script>
		// Your JavaScript code here
	</script>
</body>
</html>
