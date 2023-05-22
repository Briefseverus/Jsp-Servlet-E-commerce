<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/template/user/css/home.css' />">

<style>

</style>
</head>
<body>
    <!-- header -->
    <%@ include file="/common/user/header.jsp"%>
    <!-- header -->
    <div class="container">
        <!-- banner -->
        <div class="row">
            <%@ include file="/common/user/category.jsp"%>
            <%@ include file="/common/user/banner.jsp"%>
        </div>
        <div class="container">
            <h2>Products</h2>
            <div class="product-grid">
                <c:forEach var="product" items="${products}">
                    <c:url var="tempLink" value="Home">
                        <c:param name="action" value="load"></c:param>
                        <c:param name="product_id" value="${product.getProduct_id()}"></c:param>
                    </c:url>
                    <div class="product-card">
                        <img src="${product.product_img}" class="product-image" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">
                                <a href="${tempLink}">${product.product_name}</a>
                            </h5>
                            <p class="card-text">${product.price}</p>
                            <form method="post" action="Home">
                                <input type="hidden" name="product_id" value="${product.product_id}">
                                <input type="number" name="quantity" value="1" min="1">
                                <input type="submit" value="Add to Cart" class="add-to-cart-button btn btn-danger">
                            </form>
                        </div>
                    </div>
                </c:forEach>
            </div>
         
            <div class="cart-icon" onclick="goToCart()">
                <i class="fas fa-shopping-cart"></i> <span>${sessionScope.cartItemCount}</span>
            </div>

        </div>
    </div>
    <script>
        function goToCart() {
            window.location.href = "Cart?action=view";
        }
    </script>

    <script type="text/javascript" src="<c:url value='/template/user/jquery/jquery.min.js' />"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>
