<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<div class="col-6 mx-auto my-0">
	<div class="card mt-4">
		<div class="card-header" style="text-align: center;">
			<h6>Forgot Password</h6>
		</div>
		<div class="card-body mx-5 mt-3">
			<form name="sites/ForgotPassword" method="post">
				<div class="row">
					<div class="form-group col-12">
						<jsp:include page="/common/inform.jsp"></jsp:include>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input required name="username" type="text" class="form-control"
								aria-label="Amount (to the nearest dollar)"
								placeholder="Tài khoản">
						</div>
						<small class="form-text text-muted">Tài khoản không được
							để trống</small>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-12">
						<div class="input-group">
							<div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-envelope"></i></span>
							</div>
							<input required name="email" type="email" class="form-control"
								aria-label="Amount (to the nearest dollar)" placeholder="Email">
						</div>
						<small class="form-text text-muted">Email không được để
							trống</small>
					</div>
				</div>
				<div class="row text-center">
					<div class="form-group col ">
						<button class="btn btn-default">
							<i class="fas fa-sign-in-alt"></i> Xác nhận
						</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>