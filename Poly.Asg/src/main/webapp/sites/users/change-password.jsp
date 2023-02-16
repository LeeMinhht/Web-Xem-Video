<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<div class="col-6 mx-auto my-0">
	<div class="card mt-4">
		<div class="card-header" style="text-align: center;">
			<h6>Change Password</h6>
		</div>
		<div class="card-body mx-5 mt-3">
		
			<form action="sites/ChangePassword" method="post">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input required name="username"   type="text" value="${username}"
								class="form-control" aria-label="Amount (to the nearest dollar)"
								placeholder="Username" >
						</div>
						
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="currentPassword" 
								type="password" class="form-control"
								aria-label="Amount (to the nearest dollar)"
								placeholder="Password">
						</div>
						<small 
							class="form-text text-muted">Password can not be empty</small>
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
								placeholder="new Password">
						</div>
						<small class="form-text text-muted">New Password can not be empty</small>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="confirmPassword" 
								type="password" class="form-control"
								aria-label="Amount (to the nearest dollar)"
								placeholder=" confirm Password">
						</div>
						<small 
							class="form-text text-muted">Confirm password can not be empty</small>
					</div>
				</div>
				<div class="row text-center">
					<div class="form-group col ">
						<button class="btn btn-default">
							<i class="fas fa-sign-in-alt"></i> Change Password
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>