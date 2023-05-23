<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
</head>
<body>
	<!-- header -->
	<%@ include file="/common/user/header.jsp"%>
	<!-- header -->
	<div class="container mt-5">
		<table class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Order ID</th>
					<th>User ID</th>
					<th>Order Date</th>
					<th>Order Status</th>
					<th>View</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${pros}">
					<tr>
						<td>${pro.getOrder_id()}</td>
						<td>${pro.getUser_id()}</td>
						<td>${pro.getOrder_date()}</td>
						<td>${pro.getOrder_status()}</td>
						<td>
							<form method="post" action="OrderDisplay">
								<input type="hidden" name="orderid" value="${pro.getOrder_id()}">
								<input type="submit" value="View">
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
     <!-- footer -->
    <%@ include file="/common/user/footer.jsp"%>
    <!-- footer -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>
