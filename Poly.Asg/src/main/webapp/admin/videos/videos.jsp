<%@ page language="java" contentType="text/html; charset=ISO-utf-8"
	pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>


<div class="col">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			role="tab" href="#videoEditing" role="tab"
			aria-controls="videoEditing" aria-selected="true">Video Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link "
			id="videoList-tab" data-toggle="tab" role="tab" href="#videoList"
			role="tab" aria-controls="videoList" aria-selected="false">Video
				List</a></li>
	</ul>
	<div class="tab-content " id="myTabContent">
		<div class="tab-pane fade show active mt-3" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img src="${video.poster != null?video.poster:'images/up-min.jpg'}" alt="" class="img-fluid">
									<div class="input-group mb-3 mt-3">
										<div class="input-group-prepend">
											<span class="input-group-text">Upload</span>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="cover" name="cover">
											<label for="cover">Choose File</label>
										</div>
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtube">Youtube</label> 
									<input type="text"
										class="form-control" name="videoId" id="videoId" value="${video.videoId}"
										aria-describedby="youtubeHid" placeholder="VideoID"> <small
										id="youtubeHid" class="form-text text-muted">VideoID
										is required !</small>
								</div>
								<div class="form-group">
									<label for="title">Video title</label> 
									<input type="text" 
										class="form-control" name="title" id="title" value="${video.title}"
										aria-describedby="videoTitleHid" placeholder="Video title">
									<small id="videoTitleHid" class="form-text text-muted">Video
										title is required !</small>
								</div>
								<div class="form-group">
									<label for="viewCount">View count</label> 
									<input type="text"
										class="form-control" name="views" id="views" value="${video.views}"
										aria-describedby="viewCountHid" placeholder="View count">
									<small id="viewCountHid" class="form-text text-muted">View
										count is required !</small>
								</div>
								<div class="form-check form-check-inline">
									<label>
									<input type="radio" class="form-check-input m-2"
										name="active" value="true" id="active" ${video.active?'checked':''}>Active</label>
										 <label><input
										type="radio" class="form-check-input m-2" name="active"
										value="false" id="active" ${!video.active?'checked':''}>Inactive</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="description">Description</label>
								<textarea  name="description" id="description"  cols="30" rows="4"
									class="form-control"  value="${video.description}"></textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-center">
						<button class="btn btn-primary" formaction="admin/VideosManagement/create">Create</button>
						<button class="btn btn-warning" formaction="admin/VideosManagement/update">Update</button>
						<button class="btn btn-danger" formaction="admin/VideosManagement/delete">Delete</button>
						<button class="btn btn-info" formaction="admin/VideosManagement/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<!-- VIDEO LIST -->
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<th>Youtube ID</th>
					<th>Video Title</th>
					<th>View Count</th>
					<th>Status</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="item" items="${videos}">
				<tr>
					<td>${item.videoId}</td>
					<td>${item.title}</td>
					<td>${item.views}</td>
					<td>${item.active?'Active':'Deactive'}</td>
					<td><a href="admin/VideosManagement/edit?videoId=${item.videoId}">Edit</a> 
					<a href="admin/VideosManagement/delete?videoId=${item.videoId}" 
					class="ml-2"><iclass="fa fa-trash" aria-hidden="true"></i>Delete</a></td>
				</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</div>