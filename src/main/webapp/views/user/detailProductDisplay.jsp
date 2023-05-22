<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
          crossorigin="anonymous">
    <link rel="stylesheet" href="<c:url value='/template/user/css/detailProduct.css' />">
</head>
<body>
<!-- header -->
<%@ include file="/common/user/header.jsp"%>
<!-- header -->
<div class="container">
    <h1>${detailProduct.product_name}</h1>
    <div class="row justify-content-start">
        <div class="col-8">
            <div class="row">
                <div class="col-6">
                    <img src="${detailProduct.product_img}" alt="Product Image" class="product-detail-image">
                </div>
                <div class="col-6">
                    <div class="product-detail-info">
                        <h3>Thông tin sản phẩm</h3>
                        <p>${detailProduct.description}</p>
                        <p>Tình trạng: Còn hàng!</p>
                        <p>Bảo hành 12 tháng</p>
                        <div class="product-detail-price">Giá bán: ${detailProduct.price}đ</div>
                        <div class="product-detail-promotion">
                            <div class="card">
                                <div class="card-header">Khuyến mãi</div>
                                <div class="card-body">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item">Giảm trực tiếp khi áp dụng mã "NC50": 500.000đ</li>
                                        <li class="list-group-item">Túi/Balo laptop trị giá: 390.000đ</li>
                                        <li class="list-group-item">Giảm 5% khi mua kèm Gear, Đế tản nhiệt Laptop</li>
                                        <li class="list-group-item">Giảm 10% khi mua thêm RAM, HDD laptop</li>
                                        <li class="list-group-item">Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1 triệu đồng</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="add-to-cart-form">
                            <form method="post" action="Home">
                                <input type="hidden" name="product_id" value="${detailProduct.product_id}">
                                <input type="number" name="quantity" value="1" min="1">
                                <button class="add-to-cart-button" type="submit">Thêm vào giỏ hàng</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-4">
            <div class="product-detail-note">
                <h2>Chú ý</h2>
                <p>Chú ý: Sản phẩm có thể điều chuyển kho theo yêu cầu của quý khách</p>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
        crossorigin="anonymous"></script>
</body>
</html>

