
<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container">
		<a class="navbar-brand" href="#">Shein</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarScroll" aria-controls="navbarScroll"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<form class="d-flex" role="search">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll "
				style="-bs-scroll-height: 100px;">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Link </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Action</a></li>
						<li><a class="dropdown-item" href="#">Another action</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
			</ul>
			<c:if test="${empty user}">
				<a class="nav-link" href="/Ecommerce/login"
					style="text-decoration: none">Login</a>
				<a class="nav-link" href="/Ecommerce/register"
					style="text-decoration: none">Register</a>
			</c:if>
			<c:if test="${not empty user}">
				<li><a href="#">Xin chào, ${user.username}</a></li>
				<form method="get" action="logout">
					<input type="submit" value="Logout">
				</form>
				<form method="get" action="OrderDisplay" class="pt-3">
					<input type="hidden" name="action" value="orderList"> <input
						type="submit" value="Ordered List">
				</form>
			</c:if>
		</div>
	</div>
</nav>