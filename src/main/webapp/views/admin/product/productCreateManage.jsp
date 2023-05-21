<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Create Product</title>
<!-- Include Bootstrap 4 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h2>Create Product</h2>
		<form action="/Ecommerce/ProductManage" method="post">
			<input type="hidden" name="action" value="add"> 
			<label>Product Name:</label> <input type="text" name="product_name" required> <label>Description:</label>
			<input type="text" name="description" required> <label>Price:</label>
			<input type="text" name="price" required> <label>Product
				Image URL:</label> <input type="text" name="product_img" required> <label>Quantity:</label>
			<input type="number" name="quantity" required>
			<button type="submit">Add Product</button>
		</form>
	</div>
	<!-- Include Bootstrap 4 JavaScript and jQuery -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>