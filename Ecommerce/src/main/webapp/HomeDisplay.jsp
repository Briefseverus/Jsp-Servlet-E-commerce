<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.container {
	width: 800px;
	margin: 50px auto;
	background-color: #fff;
	border-radius: 5px;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

h1, h2 {
	text-align: center;
}

ul {
	list-style-type: none;
	padding: 0;
	margin: 0;
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
	grid-gap: 10px;
}

li {
	border: 1px solid #ccc;
	border-radius: 5px;
	padding: 10px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-between;
}

form {
	margin-top: 10px;
	text-align: center;
}

input[type="number"] {
	width: 50px;
	padding: 5px;
	border-radius: 3px;
	border: 1px solid #ccc;
	text-align: center;
}

input[type="submit"] {
	padding: 5px 10px;
	border-radius: 3px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.cart-icon {
	position: fixed;
	top: 10px;
	right: 10px;
	background-color: #4CAF50;
	color: #fff;
	padding: 5px 10px;
	border-radius: 50%;
	cursor: pointer;
}

.navbar {
	padding: 10px;
	background-color: #333;
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.navbar-brand {
	color: #fff;
	font-size: 24px;
	font-weight: bold;
}

.navbar-links {
	display: flex;
	align-items: center;
	list-style: none;
	margin: 0;
	padding: 0;
}

.navbar-link {
	margin-left: 15px;
}

.logout-btn {
	color: #fff;
}
</style>
<script>
	function goToCart() {
		window.location.href = "Cart?action=view";
	}
</script>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#">BEST PERFORMANCE PER PRICE GAMING SUITE</a>
		<ul class="navbar-links">
			<li class="navbar-link">
				<a class="nav-link" href="OrderDisplay?action=orderList">Ordered List</a>
			</li>
			<li class="navbar-link">
				<a class="nav-link" href="logout">Logout</a>
			</li>
		</ul>
		<div class="cart-icon" onclick="goToCart()">
			Cart <span>${sessionScope.cartItemCount}</span>
		</div>
	</nav>
	<div class="container">
		<h1>Welcome</h1>

		<h2>Products</h2>
		<ul>
			<c:forEach var="product" items="${products}">
				<li>
					<span><strong>Product ID:</strong> ${product.product_id}</span>
					<span><strong>Name:</strong> ${product.product_name}</span>
					<span><strong>Price:</strong> ${product.price}</span>
					<span><strong>Thumbnail:</strong></span>
					<img src="${product.getProduct_img()}" alt="Mo ta anh" width="200" height="200">
					<form method="post" action="Home">
						<input type="hidden" name="product_id" value="${product.product_id}">
						<input type="number" name="quantity" value="1" min="1">
						<input type="submit" value="Add to Cart">
					</form>
				</li>
			</c:forEach>
		</ul>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
