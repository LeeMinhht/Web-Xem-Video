<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>


<div class="col">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			role="tab" href="#videoEditing" role="tab"
			aria-controls="videoEditing" aria-selected="true">User Profile </a></li>
		<li class="nav-item" role="presentation"><a class="nav-link "
			id="videoList-tab" data-toggle="tab" role="tab" href="#videoList"
			role="tab" aria-controls="videoList" aria-selected="false">List
				User</a></li>
	</ul>
	<div class="tab-content " id="myTabContent">
		<div class="tab-pane fade show active mt-3" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img src="./images/up-min.jpg" alt="" class="img-fluid">
								</div>
							</div>
							<div class="col-9">
									<div class="row">
										<div class="form-group col-12">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i
														class="fas fa-user"></i></span>
												</div>
												<input required name="username" value="${user.username }"
													type="text" class="form-control"
													aria-label="Amount (to the nearest dollar)"
													placeholder="Username">
											</div>
											<small 
												class="form-text text-muted">Username cannot be empty</small>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-12">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i
														class="fas fa-user"></i></span>
												</div>
												<input required name="password" value="${user.password }"
													type="text" class="form-control"
													aria-label="Amount (to the nearest dollar)"
													placeholder="Password">
											</div>
											<small 
												class="form-text text-muted">Password cannot be empty</small>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-12">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i
														class="fas fa-user"></i></span>
												</div>
												<input required name="fullname" value="${user.fullname }"
													type="text" class="form-control"
													aria-label="Amount (to the nearest dollar)"
													placeholder="Fullname">
											</div>
											<small 
												class="form-text text-muted">Fullname cannot be empty</small>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-12">
											<div class="input-group">
												<div class="input-group-prepend">
													<span class="input-group-text"><i
														class="fas fa-user"></i></span>
												</div>
												<input required name="email" value="${user.email }"
													type="email" class="form-control"
													aria-label="Amount (to the nearest dollar)"
													placeholder="Password">
											</div>
											<small 
												class="form-text text-muted">Email cannot be empty</small>
										</div>
									</div>
									

							</div>
						</div>

					</div>
					<div class="card-footer text-center">

						<button class="btn btn-warning"  formaction="admin/UsersManagement/update">Update</button>
						<button class="btn btn-danger"  formaction="admin/UsersManagement/delete">Delete</button>


					</div>
				</div>
			</form>
		</div>
		<!-- VIDEO LIST -->
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<th>Username</th>
					<th>Password</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="item" items="${users}">
				<tr>
					<td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin}</td>
					<td><a href="admin/UsersManagement/edit?username=${item.username}">Edit</a></td>
					<td><a href="admin/UsersManagement/delete?username=${item.username}">Delete</a></td>
				</tr>
				</c:forEach>


			</table>

		</div>
	</div>
</div>