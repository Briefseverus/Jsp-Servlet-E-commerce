<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Update User</h2>
		<form action="UserManage" method="post" onsubmit="return dialogConfirmationUpdateProduct()">
			<input type="hidden" name="action" value="edit">
			<input type="hidden" name="user_id" value="${the_user.user_id}">
			<div class="form-group">
				<label for="username">Username:</label>
				<input type="text" class="form-control" id="username" placeholder="Enter Username" name="username" value="${the_user.username}" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" required>
			</div>
			<div class="form-group">
				<label for="full_name">Full Name:</label>
				<input type="text" class="form-control" id="full_name" placeholder="Enter Full Name" name="full_name" value="${the_user.full_name}" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label>
				<input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" value="${the_user.email}" required>
			</div>
			<div class="form-group">
				<label for="phone_number">Phone Number:</label>
				<input type="text" class="form-control" id="phone_number" placeholder="Enter Phone Number" name="phone_number" value="${the_user.phone_number}" required>
			</div>
			<button onclick="checkUpdateConfirmation()" class="btn btn-default">SAVE</button>
			<a type="button" href="UserManage" class="btn btn-primary">Cancel</a>
		</form>
	</div>
	<script>
		let text = "Do you want to update the user?";
		let checkMessage = "";

		function checkUpdateConfirmation() {
			if (confirm(text)) {
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
</body>
</html>
