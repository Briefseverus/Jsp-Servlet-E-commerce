<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Magazine</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
</head>
<body>
	<div class="container">
		<h2>Update Product</h2>
		<form action="ProductManage" method="Post" onsubmit="return dialogConfirmationUpdateProduct()">
			<input type="hidden" name="action" value="edit"> <input
				type="hidden" name="product_id" value="${the_product.product_id}">
			<div class="form-group">
				<label for="product_name">Name:</label>
				<textarea class="form-control" id="product_name"
					placeholder="Enter Title" name="product_name">${the_product.product_name}</textarea>
			</div>

			<div class="form-group">
				<label for="price">Price:</label> 
				<input type="number"
					class="form-control" id="price" placeholder="Enter Price"
					name="price" value="${the_product.price}" required>
			</div>
			<div class="form-group">
				<label for="description">Description:</label> <input type="text"
					class="form-control" id="description" placeholder="Enter description"
					name="description" value="${the_product.description}" required>
			</div>
				<div class="form-group">
				<label for="product_img">img:</label> <input type="text"
					class="form-control" id="description" placeholder="Enter product_img"
					name="product_img" value="${the_product.product_img}" required>
			</div>
			<div class="form-group">
				<label for="quantity">quantity:</label> 
				<input type="number"
					class="form-control" id="quantity" placeholder="Enter quantity"
					name="quantity" value="${the_product.quantity}" required>
			</div>
			<button onclick="checkUpdateConfirmation()" class="btn btn-default">SAVE</button>
			<a type="button" href="ProductManage" class="btn btn-primary">CANCEL</a>
		</form>
	</div>
</body>
<script>
    let text = "Do you want to Update product ?";
    let checkMessage = ""
    function checkUpdateConfirmation() {
        if (confirm(text) == true) {
            checkMessage = "OK";
        } else {
            checkMessage = "CANCEL";
        }
    }

    function dialogConfirmationUpdateProduct() {
        if (checkMessage === "OK") {
            return true;
        } else {
            return false;
        }
    }
</script>
</html>