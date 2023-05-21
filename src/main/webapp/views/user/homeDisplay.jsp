<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-REzdyk/ZVt5TNK8hDmBp+q19xaZ1Q8JpO0kZdqvcQmN9y8hZS+0EGRvriJwm+NkEJ7bWcF4/FdX8U3t08A2DLg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="<c:url value='/template/user/css/style.css' />"></link>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>
	<!-- header -->
	<!-- banner -->
	<%@ include file="/common/user/banner.jsp"%>
	<!-- banner -->
<script>
		function goToCart() {
			window.location.href = "Cart?action=view";
		}
	</script>
	<div class="container">
	<h2>Products</h2>
	<div class="row row-cols-1 row-cols-md-3 g-4">
		<c:forEach var="product" items="${products}">
			<c:url var="tempLink" value="Home">
				<c:param name="action" value="load"></c:param>
				<c:param name="product_id" value="${product.getProduct_id()}"></c:param>
			</c:url>
			  <div class="col">
			    <div class="card">
			      <img src=${product.product_img} class="card-img-top" alt="...">
			      <div class="card-body">
			        <h5 class="card-title"><a type="button"
					class="btn btn-primary btn-sm" href="${tempLink}">${product.product_name}</a></h5>
			        <p class="card-text">${product.price}</p>
			        <form method="post" action="Home">
						<input type="hidden" name="product_id"
							value="${product.product_id}"> <input type="number"
							name="quantity" value="1" min="1"> <input type="submit"
							value="Add to Cart">
					</form>
					
			      </div>
			    </div>
			  </div>
			</c:forEach>
		</div>
		<form method="get" action="OrderDisplay" class="pt-3">
			<input type="hidden" name="action" value="orderList"> <input
			type="submit" value="Ordered List">
		</form>
		<div class="cart-icon" onclick="goToCart()">
		    <i class="fas fa-shopping-cart"></i> Cart <span>${sessionScope.cartItemCount}</span>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>
