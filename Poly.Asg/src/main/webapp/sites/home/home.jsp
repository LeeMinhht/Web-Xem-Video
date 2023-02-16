<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>


<div class="item">
	

	<div class="row">
	<jsp:include page="/common/inform.jsp"></jsp:include>
	<c:forEach var="item" items="${video}">
		<div class="col-3">
			<div class="card mt-3" style="border: none; background-color: white;">
aa
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
	<div class="btn-toolbar" role="toolbar"
					aria-label="Toolbar with button groups" style="margin-left: 500px; margin-bottom: 50px">
					<div class="btn-group mr-2" role="group" aria-label="First group">
					<c:forEach begin="1" end="${endPage}" var="item">
						<a id="${tag == item?'active':''}" href="sites/Homepage?index=${item}" type="button" class="btn btn-secondary">${item}</a>
					</c:forEach>
					</div>
					
				</div>
</div>


