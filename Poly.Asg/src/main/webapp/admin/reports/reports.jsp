<%@ page language="java" contentType="text/html; charset=ISO-utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<div class="col">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="favorires-tab" data-toggle="tab"
			role="tab" href="#favorires" role="tab" aria-controls="favorires"
			aria-selected="true">Favorites</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link "
			id="favoriteUser-tab" data-toggle="tab" role="tab"
			href="#favoriteUser" role="tab" aria-controls="favoriteUser"
			aria-selected="false">Favorite User</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link "
			id="sharedFriend-tab" data-toggle="tab" role="tab"
			href="#sharedFriend" role="tab" aria-controls="sharedFriend"
			aria-selected="false">Shared Friend</a></li>
	</ul>
	<div class="tab-content " id="myTabContent">
		<div class="tab-pane fade show active mt-3" id="favorires"
			role="tabpanel" aria-labelledby="favorires-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<th>Video Title</th>
					<th>Favorite Count</th>
					<th>Latest Date</th>
					<th>Oldest Date</th>

				</tr>
				<c:forEach var="item" items="${favList}">
					<tr>
						<td>${item.videoTitle}</td>
						<td>${item.favoriteCount}</td>
						<td>${item.newestDate}</td>
						<td>${item.oldestDate}</td>

					</tr>
				</c:forEach>

			</table>
		</div>
		<!-- VIDEO LIST -->
		<div class="tab-pane fade" id="favoriteUser" role="tabpanel"
			aria-labelledby="favoriteUser-tab">
			<form action="" method="get">
				<div class="col-6 mx-auto mt-3">
					<label>Video Title <select
						class="form-control form-control-lg" name="videoUserId"
						id="videoUserId">
							<c:forEach var="item" items="${vidList}">
								<option value="${item.videoId}"
									${item.videoId == videoUserId?'selected':''}>${item.title}</option>
							</c:forEach>
					</select>
					</label>
					<button class="btn btn-info ml-2">Report</button>
				</div>
				<table class="table table-bordered mt-3">
					<tr>
						<th>Username</th>
						<th>Fullname</th>
						<th>Email</th>
						<th>Favorite Date</th>

					</tr>
					<c:forEach var="item" items="${favUsers}">
						<tr>
							<td>${item.username}</td>
							<td>${item.fullname}</td>
							<td>${item.email}</td>
							<td>${item.likeDate}</td>

						</tr>
					</c:forEach>

				</table>
			</form>
		</div>

		<!-- Shared Friend -->
		<div class="tab-pane fade" id="sharedFriend" role="tabpanel"
			aria-labelledby="sharedFriend-tab">
			<form action="" method="get">
				<div class="col-6 mx-auto mt-3">
					<label>Video Title <select
						class="form-control form-control-lg" name="videoUserId"
						id="videoUserId">
							<c:forEach var="item" items="${videoList}">
								<option value="${item.videoId}"
									${item.videoId == videoUserId?'selected':''}>${item.title}</option>
							</c:forEach>
					</select>
					</label>
					<button class="btn btn-info ml-2">Report</button>
				</div>
				<table class="table table-bordered mt-3">
					<tr>
						<th>Sender Name</th>
						<th>Sender Email</th>
						<th>Receiver Email</th>
						<th>Sent Date</th>

					</tr>
					<c:forEach var="item" items="${videoTT}">
						<tr>
							<td>${item.senderName}</td>
							<td>${item.senderEmail}</td>
							<td>${item.receiverEmail}</td>
							<td>${item.sentDate}</td>
						</tr>
					</c:forEach>


				</table>
			</form>
		</div>
	</div>
</div>