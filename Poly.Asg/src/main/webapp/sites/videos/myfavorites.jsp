<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>


<div class="item">
	<div class="row">
	<c:forEach var="item" items="${video}">
		<div class="col-3">
			<div class="card mt-5" style="border: none; background-color: white;">

				<div class="card-body">
					<a href="sites/Detail?videoId=${item.videoId}">
					<img src="${empty item.poster ? './images/up-min.jpg': item.poster}" width="300px" height="170px" halt=""
						style="border: none; border-radius: 10px 10px;">
						</a>
						
				</div>
				<div class="card-footer text-muted"
					style="background-color: white; border: 0; margin-top: -15px;">
					<h6>${item.title}</h6>
					
					<p style="font-size: 12px">${item.view} View</p>
					<p style="font-size: 12px"> time: ${item.likeDate}</p>
					<a href="sites/UnlikeVideo?favoriteId=${item.favoriteId}" class="btn btn-success">Unlike</a>
					<a href="sites/ShareVideo?videoId=${item.videoId}" class="btn btn-info">Share</a>
				</div>
			</div>
		</div>
		</c:forEach>

	</div>
</div>


