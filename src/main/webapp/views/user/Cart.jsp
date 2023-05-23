<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cart</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <style>
        .cart-item-image {
            max-width: 100px;
            max-height: 100px;
            object-fit: contain;
        }

        .cart-total-price {
            font-size: 24px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<!-- header -->
<%@ include file="/common/user/header.jsp"%>
<!-- header -->
<div class="container mt-5">
    <h1>Your Cart</h1>
    <table class="table table-striped table-bordered">
        <thead class="thead-light">
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cartItems}">
            <tr>
                <td>
                    <img src="${item.productImg}" alt="Mo ta anh" class="cart-item-image">
                    ${item.productName}
                </td>
                <td>${item.price}</td>
                <td>${item.quantity}</td>
                <td>${item.getTotalPrice()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="row">
        <div class="col-8">Hello</div>
        <div class="col-4">
            <table class="table table-striped table-bordered">
                <thead class="thead-light">
                <tr>
                    <th>Total Price</th>
                </tr>
                </thead>
                <tbody>
                <td class="cart-total-price">${cart.getTotalPrice()}</td>
                </tbody>
            </table>
            <form method="post" action="Cart">
                <input type="hidden" name="action" value="checkout" class="btn btn-danger">
                <input type="submit" value="Checkout" class="btn btn-danger">
            </form>
            	<form method="get" action="OrderDisplay" class="pt-3">
					<input type="hidden" name="action" value="orderList"> 
					<input type="submit" value="Ordered List" class="btn btn-danger" >
				</form>
        </div>
    </div>
</div>
     <!-- footer -->
    <%@ include file="/common/user/footer.jsp"%>
    <!-- footer -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
