<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
	role="navigation">
	<div class="container">

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="${contextRoot}/home">Let's EAT @</a></li>
			</ul>
		</div>

		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">

				<li id="home" class="nav-item"><a class="nav-link"
					href="${contextRoot}/home">Home</a></li>
				<li id="about" class="nav-item"><a class="nav-link"
					href="${contextRoot }/about">About</a></li>
				<li id="contact" class="nav-item"><a class="nav-link"
					href="${contextRoot }/contact">Contact</a></li>
				<li id="listItems" class="nav-item"><a class="nav-link"
					href="${contextRoot }/show/all/items">Items</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li id="manageItems" class="nav-item"><a class="nav-link"
						href="${contextRoot }/manage/items">Manage Items</a></li>
				</security:authorize>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<security:authorize access="isAnonymous()">
					<li id="register" class="nav-item"><a class="nav-link"
						href="${contextRoot}/register">Sign Up</a></li>
					<li id="login" class="nav-item"><a class="nav-link"
						href="${contextRoot}/login">Login</a></li>
				</security:authorize>

				<!-- Logout code -->
				<security:authorize access="isAuthenticated()">
					<li class="dropdown" id="userCart"><a href="javascript:void(0)"
						id="dropdownMenu1" data-toggle="dropdown">${userModel.fullName}<span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('USER')">
								<li><a href="${contextRoot}/cart/show"> <span
										class="glyphicon glyphicon-shopping-cart"></span> <span
										class="badge">${userModel.cart.cartLines}</span> - &#8377;
										${userModel.cart.grandTotal}
								</a></li>
								<li role="separator" class="divider"></li>
							</security:authorize>
							<li><a href="${contextRoot}/perform-logout">Logout</a></li>
						</ul></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>

<script>
	window.userRole = '${userModel.role}';
</script>