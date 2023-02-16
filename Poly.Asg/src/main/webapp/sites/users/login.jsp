<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<div class="col-6 mx-auto my-0">
	<div class="card mt-4">
		<div class="card-header" style="text-align: center;">
			<h6>Login</h6>
		</div>
		<div class="card-body mx-5 mt-3">
			<form action="" method="post">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input required name="username" type="text"
								class="form-control" aria-label="Amount (to the nearest dollar)"
								placeholder="Username">
						</div>
						<small 
							class="form-text text-muted">Username is required</small>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="password" 
								type="password" class="form-control"
								aria-label="Amount (to the nearest dollar)"
								placeholder="Password">
						</div>
						<small 
							class="form-text text-muted">Password is required</small>
					</div>
				</div>
				<div class=" form-check form-check-inline">
				<label> <input type="checkbox" class="form-check-input" name="remember">Remember me </label>
				</div>
				<div class="row text-center">
					<div class="form-group col ">
						<button class="btn btn-default">
							<i class="fas fa-sign-in-alt"></i> Sign in
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>