<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>


<form action="sites/Detail" method="post">
	<div class="row" style="margin-right: 5px">
		<div class="col-8">
			<div class="card" style="border: none;">
				<div class="card-header"
					style="border: none; border-radius: 10px 10px;">
					<iframe width="100%" height="500"
						style="border: none; border-radius: 10px 10px;"
						src="${video.description}" title="YouTube video player"
						frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
				<div class="card-body" style="border: none;">
					<h4 class="card-title">${video.title}</h4>
					<p>${video.views}Views</p>

				</div>
				<div class="card-footer text-muted" style="border: none;">
					<c:if test="${!checkLike}">
						<a href="sites/LikeVideo?videoId=${video.videoId}"
							class="btn btn-success">Like</a>
					</c:if>
					<c:if test="${checkLike}">
						<a href="sites/UnlikeVideo?favoriteId=${favorite.favoriteId}"
							class="btn btn-success">UnLike</a>
					</c:if>
					<a href="sites/ShareVideo?videoId=${video.videoId}"
						class="btn btn-info">Share</a>
				</div>
			</div>
		</div>

		<div class="col-4">

			<c:forEach var="item" items="${videos}">
				<div class="card" style="border: none;">
					<div class="card-header"
						style="background-color: white; border: none;">
						<a href="sites/Detail?videoId=${item.videoId}"> <img alt=""
							src="${item.poster}" width="50%" height="100px"
							style="border-radius: 10px 10px;">
						</a>


						<div class="card-title"
							style="float: left; margin-left: 200px; margin-top: -100px">
							<h6>${item.title}</h6>
							<span style="font-size: 12px">${item.views} Views </span> <br>
						</div>


					</div>


				</div>
			</c:forEach>

		</div>
	</div>
</form>

