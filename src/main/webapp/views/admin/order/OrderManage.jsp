<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="ecommerce.com.daos.UserDao"%>
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
			<h1>Order List</h1>

			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>Order ID</th>
						<th>User ID</th>
						<th>Date</th>
						<th>Status</th>
						<th>User Name</th>
						<th>Full Name</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pro" items="${pros}">
						<tr>
							<td>${pro.getOrder_id()}</td>
							<td>${pro.getUser_id()}</td>
							<td>${pro.getOrder_date()}</td>
							<td>${pro.getOrder_status()}</td>
							<td><c:set var="user"
									value="${UserDao.getuserById(pro.getUser_id())}" /> <c:if
									test="${user != null}">
                ${user.getUsername()}
            </c:if></td>
							<td><c:set var="user"
									value="${UserDao.getuserById(pro.getUser_id())}" /> <c:if
									test="${user != null}">
                ${user.getFull_name()}
            </c:if></td>
							<td>
								<form action=OrderManage method="post"
									style="display: inline;">
									<input type="hidden" name="action" value="delete"> <input
										type="hidden" name="order_id" value="${pro.getOrder_id()}">
									<button class="btn btn-danger btn-sm" type="submit"
										onclick="if(!(confirm('Do you want to delete product??'))) return false">Delete</button>
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