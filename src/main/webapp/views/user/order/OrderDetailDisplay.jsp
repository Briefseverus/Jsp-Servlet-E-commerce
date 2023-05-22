<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of Product</title>
<!-- Include Bootstrap 4 CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>
	<!-- header -->
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
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>
