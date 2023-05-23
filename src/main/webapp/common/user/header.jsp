<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
a {
	text-decoration: none;
}

li {
	list-style: none;
}

.search {
	flex-grow: 1;
	text-align: center;
	margin-left: 20rem;
}

.search input {
	width: 100%;
	max-width: 350px;
	border-radius: 20px;
	transition: box-shadow 0.3s;
}

.search input:focus {
	box-shadow: 0 0 5px #ff5a5f;
}

.nav-link {
	color: #333;
	transition: color 0.3s;
}

.nav-link:hover, .nav-link.active {
	color: #ff5a5f;
}

.nav-item.user {
	margin-top: 8.5px;
	padding-left: 5px;
	transition: color 0.3s;
	position: relative;
}

.nav-item.user:hover {
	color: #ff5a5f;
}

.nav-item.user::before {
	content: "";
	position: absolute;
	bottom: -3px;
	left: 0;
	width: 0;
	height: 2px;
	background-color: #ff5a5f;
	transition: width 0.3s;
}

.nav-item.user:hover::before {
	width: 100%;
}

.nav-item.user form {
	display: inline-block;
	margin-left: 10px;
}

.nav-item.user input[type="submit"] {
	border: none;
	background-color: transparent;
	color: #ff5a5f;
	cursor: pointer;
	transition: color 0.3s;
}

.nav-item.user input[type="submit"]:hover {
	color: #ff5a5f;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container">
			<a class="navbar-brand" href="#">ECOMMERCE</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarScroll"
				aria-controls="navbarScroll" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarScroll">
				<div class="search">
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
					</form>
				</div>
				<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll "
					style="-bs-scroll-height: 100px;">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Hệ thống cửa hàng</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Gọi mua
							Hàng</a></li>
					<c:if test="${empty user}">
						<a class="nav-link" href="/Ecommerce/login"
							style="text-decoration: none">Login</a>
						<a class="nav-link" href="/Ecommerce/register"
							style="text-decoration: none">Register</a>
					</c:if>
					<c:if test="${not empty user}">
						<li class="nav-item user"><a href="#">Xin chào,
								${user.username}</a></li>
						<li class="nav-item user">
							<form method="get" action="logout">
								<input type="submit" value="Logout">
							</form>
						</li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>