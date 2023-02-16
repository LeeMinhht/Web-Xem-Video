<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<!doctype html>
<html lang="en">
<head>
<title>${page.title}</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href='css/style.css'>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<base href="/Poly.Asg/">
<body>
	<div>
		<header>
			<div class="mx-auto" id="menu">
				<ul>
					<li class=""><i class="fas fa-video logoAr"
						style="color: red; font-size: 35PX;"></i></li>
					<li style="margin-left: -10px; margin-top: 23px;"><span
						class="logo-title"><a href="Homepage">ONLINE
								ENTERTAINMENT</a></span></li>

					<li class="liSearch">
						<form action="sites/SearchVideo" method="post" class="d-flex"
							role="search">
							<input class="form-control me-2 cus" type="search" name="title"
								value="${title}" placeholder="Search" aria-label="Search"
								style="border-radius: 15px 15px;">
							<button class="btn btn-outline-success cus" type="submit"
								id="search" style="border-radius: 15px 15px;">Search</button>

						</form>

					</li>


				</ul>


				<div class="navBar" style="margin-top: 120px">
					<a href="#" class="badge badge-secondary">Animal</a> <a href="#"
						class="badge badge-secondary" style="width: 120px">Science
						Fiction</a> <a href="#" class="badge badge-secondary"
						style="width: 120px">technology</a> <a href="#"
						class="badge badge-secondary" style="width: 120px">Onion</a> <a
						href="#" class="badge badge-secondary">War</a> <a href="#"
						style="width: 120px" class="badge badge-secondary">Comedy</a> <a
						href="#" style="width: 120px" class="badge badge-secondary">Light</a>
					<a href="#" class="badge badge-secondary" style="width: 120px">Light</a>


				</div>

				<div class="dropdown acount" id="ropdowul2"
					style="margin-left: 50px">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						data-toggle="dropdown" aria-expanded="false"
						style="width: 40px; height: 40px; background-color: ;
						 border-radius: 50%; moz-border-radius: 50%; webkit-border-radius: 50%;">
						<i class="fas fa-user"></i>
					</button>
					<div class="dropdown-menu">
						<c:if test="${!isLogin}">
							<a class="dropdown-item" href="sites/Login">Login</a>
							<a class="dropdown-item" href="sites/Registration">Registration</a>
							<a class="dropdown-item" href="sites/ForgotPassword">Forgot
								Password</a>
						</c:if>
						<c:if test="${isLogin}">
							<a class="dropdown-item" href="sites/ChangePassword">Change
								Password</a>
							<a class="dropdown-item" href="sites/EditProfile">Edit
								Profile</a>
							<a class="dropdown-item" href="sites/Logoff">Logout</a>
						</c:if>
					</div>
					
				</div>
				<div style="">
					<c:if test="${isLogin}">
						<h6 style="margin-top: 25px; margin-left: -40px">${username}</h6>
					</c:if>
					</div>

			</div>
		</header>
		<section class="row">
			<aside class="col-2 mt-2">
				<div class="divNav">
					<ul class="ULNav">
						<li class="liAr"><i class="fas fa-home logoAr"></i><a
							href="sites/Homepage">Home</a></li>
						<li class="liAr"><i class="fas fa-book logoAr"></i><a
							href="#">Contact Us</a></li>
						<li class="liAr"><i class="fas fa-star logoAr"></i><a
							href="sites/MyFavorites">My Favorites</a></li>
						<li class="liAr"><i class="fas fa-address-card logoAr "></i><a
							href="#">About Us</a></li>
						<li class="liAr"><i class="fas fa-edit logoAr"></i><a
							href="sites/AllFavoritesVideo">Trending</a></li>
						<li class="liAr"><i class="fas fa-edit logoAr"></i><a
							href="#">Help</a></li>

					</ul>
				</div>
			</aside>
			<article class="col-10 mt-2">
				<jsp:include page="${page.contenUrl}"></jsp:include>

			</article>

		</section>

	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl}"></jsp:include>
	</c:if>
</body>
</html>