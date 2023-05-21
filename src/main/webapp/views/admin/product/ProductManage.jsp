<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Quan Tri</title>
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' />" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/assets/css/ace.min.css' />"
	class="ace-main-stylesheet" id="main-ace-style" />
<script
	src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type='text/javascript'
	src='<c:url value="/template/admin/js/jquery-2.2.3.min.js" />'></script>
<script
	src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script
	src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

<script src="<c:url value='/ckeditor/ckeditor.js' />"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<!-- header -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- header -->

		<div class="container mt-5">
			<h1>Product List</h1>
			<form action="views/admin/product/productCreateManage.jsp"
				method="post" style="display: inline;">
				<button type="submit">Create</button>
			</form>
			
			
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Product Img URL</th>
						<th>Thumbnail</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pro" items="${pros}">

						<c:url var="upload" value="ProductManage">
							<c:param name="action" value="load"></c:param>
							<c:param name="product_id" value="${pro.getProduct_id()}"></c:param>
						</c:url>
				
						<tr>
							<td>${pro.getProduct_id()}</td>
							<td>${pro.getProduct_name()}</td>
							<td>${pro.getDescription()}</td>
							<td>${pro.getPrice()}</td>
							<td>${pro.getQuantity()}</td>
							<td>${pro.getProduct_img()}</td>
							<td><img src="${pro.getProduct_img()}" alt="Mo ta anh"
								width="100" height="100"></td>
							<td>
								<a type="button" class="btn btn-primary btn-sm" href="${upload}">upload</a>
								<form action="ProductManage" method="post"
									style="display: inline;">
									<input type="hidden" name="action" value="delete"> 
									<input type="hidden" name="product_id" value="${pro.getProduct_id()}">
								<button class="btn btn-danger btn-sm" type="submit" onclick="if(!(confirm('Do you want to delete product??'))) return false">Delete</button>
								</form>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/common/admin/footer.jsp"%>
	<!-- footer -->

	<a href="#" id="btn-scroll-up"
		class="btn-scroll-up btn btn-sm btn-inverse display"> <i
		class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	</div>


	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
	<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
	<script
		src="<c:url value='/template/admin/assets/js/bootstrap.min.js'/>"></script>

	<!-- page specific plugin scripts -->
	<script
		src="<c:url value='/template/admin/assets/js/jquery-ui.min.js'/>"></script>
</body>
</html>