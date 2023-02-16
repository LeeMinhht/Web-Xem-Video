<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>


<div class="item">
	

	<div class="row">
	<jsp:include page="/common/inform.jsp"></jsp:include>
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
					style="background-color: white; border: 0; margin-top: -15px; ">
					<h6 style="font-weight: bold;">${item.title}</h6>
					<p style="font-size:12px ">${item.views} Views</p>
				</div>
			</div>
		</div>
		</c:forEach>

	</div>
</div>


