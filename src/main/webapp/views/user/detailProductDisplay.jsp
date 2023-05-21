<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<c:url value='/template/user/css/style.css' />"></link>
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
						<img src="${detailProduct.product_img}" alt="Mo ta anh"
							style="height: 300px">
					</div>
					<div class="col-6">
						<h3>Thông tin sản phẩm</h3>
						<p>${detailProduct.description}</p>
						<p>Tình trạng: Còn hàng !</p>
						<p>Bảo hành 12 tháng</p>
						<div class="card w-50">
							<div class="card-body">
								<h5 class="alert alert-danger">Giá bán:
									${detailProduct.price}đ</h5>
							</div>
						</div>
						<div class="card pt-3">
							<div class="card-header">Khuyến mãi</div>
							<div class="card-body">
								<blockquote class="blockquote mb-0">
									<p>Giảm trực tiếp khi áp dụng mã "NC50" : 500.000đ</p>
									<p>Túi/Balo laptop trị giá : 390.000đ</p>
									<p>Giảm 5% khi mua kèm Gear, Đế tản nhiệt Laptop</p>
									<p>Giảm 10% khi mua thêm RAM, HDD laptop</p>
									<p>Vệ sinh bảo dưỡng Laptop miễn phí trọn đời trị giá: 1
										triệu đồng</p>
								</blockquote>
							</div>
						</div>
						<div class="d-grid gap-2 pt-3">
							<button class="btn btn-danger" type="button">Đặt mua
								ngay</button>
						</div>

					</div>
				</div>
			</div>
			<div class="col-4">
				<div class="card">
					<div class="card-header">Sản phẩm còn tại</div>
					<div class="card-body">
						<blockquote class="blockquote mb-0">
							<h2>Chú ý</h2>
							<p>Chú ý: sản phẩm có thể điều chuyển kho theo yêu cầu của quý khách</p>
				
						</blockquote>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>

</html>