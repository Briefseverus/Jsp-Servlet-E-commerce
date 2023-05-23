<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>List of Product</title>
<!-- Include Bootstrap 4 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

<style>
	.container {
		margin-top: 30px;
	}

	.table {
		background-color: #fff;
	}

	.table thead th {
		background-color: #343a40;
		color: #fff;
		border-color: #343a40;
	}

	.table-striped tbody tr:nth-of-type(odd) {
		background-color: #f8f9fa;
	}

	.table-bordered th,
	.table-bordered td {
		border: 1px solid #dee2e6;
	}

	.product-img {
		max-width: 100px;
		height: auto;
	}

	.total-price {
		font-weight: bold;
		margin-top: 20px;
	}
</style>

</head>
<body>
	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>
	<!-- header -->
	<div class="container">
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
						<td><img class="product-img" src="${pro.productImg}" alt="Product Image"></td>
						<td>${pro.price}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" class="total-price">Total Price: ${cart.getTotalPrice()}</td>
				</tr>
			</tbody>
		</table>
	</div>
     <!-- footer -->
    <%@ include file="/common/user/footer.jsp"%>
    <!-- footer -->
	<!-- Include Bootstrap 4 JavaScript and jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>

</body>
</html>
