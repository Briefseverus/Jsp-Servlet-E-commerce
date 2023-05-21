<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

</head>
<body>
</body>
<div class="container mt-5">
	<h1>Your Cart</h1>
	<table class="table table-striped table-bordered">
		<thead class="thead-dark">
			<tr>
				<th>Product ID</th>
				<th>Name</th>
				<th>Product Img URL</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${cartItems}">
				<tr>
					<td>${item.productId}</td>
					<td>${item.productName}</td>
					<td><img src="${item.productImg}" alt="Mo ta anh" width="300"
						height="300"></td>
					<td>${item.price}</td>
					<td>${item.quantity}</td>
					<td>${item.getTotalPrice()}</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	<p>${cart.getTotalPrice()}</p>
	<form method="post" action="Cart">
		<input type="hidden" name="action" value="checkout"> <input
			type="submit" value="Checkout">
	</form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script>
	</body>
	</html>
