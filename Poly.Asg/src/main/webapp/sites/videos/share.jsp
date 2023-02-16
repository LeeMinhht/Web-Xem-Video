<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="ftm"%>

<div class="offset-3 col-6">
	<form action="sites/ShareVideo" method="post">
		<div class="card">
			<div class="card-header">Send video to your friend</div>
			<input type="hidden" name="videoId" value="${videoId}">
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="email">your friend email: </label> <input type="text"
								name="email" id="" class="form-control" placeholder="Email"
								aria-describedby="helpId"> <small id="helpId"
								class="text-muted">Email is required</small>
						</div>
					</div>
				</div>

			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Send</button>
			</div>
		</div>
	</form>
</div>