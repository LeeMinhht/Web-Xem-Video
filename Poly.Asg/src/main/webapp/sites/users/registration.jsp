<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<div class="col-6 mx-auto my-0">
	<form action="" method="post">
	${Router.SITE_REGISTRATION_SHOW}
	<div class="card mt-4">
		<div class="card-header" style="text-align: center;">
			<h6>Create Account</h6>
		</div>
		<div class="card-body mx-5 mt-3">

			
				<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input required name="username" value="${user.username}"
								type="text" class="form-control"
								aria-label="Amount (to the nearest dollar)"
								placeholder="Username">
						</div>
						<small class="form-text text-muted">Username cannot be empty</small>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="password" type="password"
								class="form-control" aria-label="Amount (to the nearest dollar)"
								placeholder="Password">
						</div>
						<small class="form-text text-muted">Password cannot be empty</small>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="fullname" value="${user.fullname}"
								type="text" class="form-control"
								aria-label="Amount (to the nearest dollar)" placeholder="Fullname">
						</div>
						<small class="form-text text-muted">Fullname cannot be empty</small>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="email" value="${user.email}" type="text"
								class="form-control" aria-label="Amount (to the nearest dollar)"
								placeholder="Email">
						</div>
						<small class="form-text text-muted">Email cannot be empty</small>
					</div>
				</div>
				<div class="row text-center">
					<div class="form-group col ">
						<button class="btn btn-default">
							<i class="fas fa-sign-in-alt"></i> Sign Up
						</button>
					</div>
				</div>
			

		</div>
	</div>
	</form>
</div>