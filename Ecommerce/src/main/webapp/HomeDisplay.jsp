<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<style>
.cart-icon {
	position: fixed;
	top: 10px;
	right: 10px;
	background-color: #ccc;
	padding: 5px 10px;
	border-radius: 50%;
	cursor: pointer;
}
</style>
<script>
	function goToCart() {
		window.location.href = "Cart?action=view";
	}
</script>
</head>
<body>
	<h1>Welcome to the Home Page</h1>

	<h2>Products</h2>
	<ul>
		<c:forEach var="product" items="${products}">
			<li><span><strong>Product ID:</strong>
					${product.product_id}</span> <span><strong>Name:</strong>
					${product.product_name}</span> <span><strong>Price:</strong>
					${product.price}</span>
				<form method="post" action="Home">
					<input type="hidden" name="product_id"
						value="${product.product_id}"> <input type="number"
						name="quantity" value="1" min="1"> <input type="submit"
						value="Add to Cart">
				</form></li>
		</c:forEach>
	</ul>
	<form method="get" action="OrderDisplay">
		<input type="hidden" name="action" value="orderList"> <input
			type="submit" value="Ordered List">
	</form>
	<form method="get" action="logout">
		<input type="submit" value="Logout">
	</form>

	<div class="cart-icon" onclick="goToCart()">
		Cart <span>${sessionScope.cartItemCount}</span>

	</div>


</body>
</html>
