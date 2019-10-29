<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		//수락버튼
		$(".btnOk").click(function() {
			var meet_num = $(this).attr('data-join-idx');
			var parent_tr = $(this).parents('tr');

			data = {
				'meet_num' : meet_num
			};
			// 			console.log(data);

			$.post('/registShow/changeY', data, function(rData) {
				if (rData == "SUCCESS") {
					alert("수락되었습니다.");
					parent_tr.fadeOut(600);
					// 					parent_tr.remove();
				} else {
					alert("서버 에러");
				}
			});
		});
		// 			$.ajax({
		// 				'url' : '/registShow/changeY',
		// 				'data' : data,
		// 				'dataType' : 'text',
		// 				'type' : 'post',
		// 				'success' : function(rData){
		// 					if(rData == "SUCCESS"){
		// 						alert("수락되었습니다.")
		// 						parent_tr.remove();
		// 					} else{
		// 						alert("서버 에러");
		// 					}
		// 				}
		// 			});

		//거절버튼
		$(".btnEsc").click(function() {
			var join_idx = $(this).attr('data-join-idx');
			var parent_tr = $(this).parents('tr');
			data = {
				'join_idx' : join_idx
			};
			console.log(data);
			$.post('/registShow/delete', data, function(rData2) {
				if (rData2 == "SUCCESS") {
					alert("삭제되었습니다.");
					parent_tr.fadeOut(600);
					// 					parent_tr.remove();
				} else {
					alert("서버 에러가 생겼습니다.");
				}
			});
		});
		// 			$.ajax({
		// 				'url' : '/delete',
		// 				'data' : data,
		// 				'dataType' : 'text',
		// 				'headers' : {
		// 					'Content-Type' : 'application/json',
		// 					'X-Http-Method-Override' : 'POST'
		// 				},
		// 				'type'  : 'delete',
		// 				'success' : function(rData){
		// 					if (rData == 'SUCCESS') {
		// 						parent_tr.remove();
		// 					} else {
		// 						alert('서버 에러');
		// 					}
		// 				}
		// 			});

	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<h3 class="text-center text-danger">My Page (마이페이지)</h3>
				<div class="carousel slide" id="carousel-536213">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-536213"></li>
						<li data-slide-to="1" data-target="#carousel-536213"></li>
						<li data-slide-to="2" data-target="#carousel-536213"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="Carousel Bootstrap First"
								src="http://lorempixel.com/output/sports-q-c-1600-500-1.jpg" />
							<div class="carousel-caption">
								<h4>First Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="item">
							<img alt="Carousel Bootstrap Second"
								src="http://lorempixel.com/output/sports-q-c-1600-500-2.jpg" />
							<div class="carousel-caption">
								<h4>Second Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
						<div class="item">
							<img alt="Carousel Bootstrap Third"
								src="http://lorempixel.com/output/sports-q-c-1600-500-3.jpg" />
							<div class="carousel-caption">
								<h4>Third Thumbnail label</h4>
								<p>Cras justo odio, dapibus ac facilisis in, egestas eget
									quam. Donec id elit non mi porta gravida at eget metus. Nullam
									id dolor id nibh ultricies vehicula ut id elit.</p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-536213"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-536213"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
				<div class="row">
					<div class="col-md-2">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<h3 class="panel-title">------</h3>
							</div>
							<div class="container-fluid">
								<div class="row">
									<div class="col-md-12">
										<c:if test="${dto.state_name eq '모집대기중'}">
											<button type="button" id="requestedShowBtn"
												class="btn btn-default">나에게 신청한 사람들 상세보기</button>
										</c:if>
										<c:if test="${dto.state_name eq '만남중'}">
											<button type="button" id="completeBtn"
												class="btn btn-default">매칭완료</button>
										</c:if>
									</div>
								</div>
							</div>
							<div class="panel-body">
								<a href="shortRequestedShow">Short meet(짧은 만남)</a>
							</div>
							<div class="panel-body">
								<a href="longRequestedShow">Lonng meet(긴 만남)</a>
							</div>
							<div class="panel-body">
								<a href="groupRequestedShow">Group meet(단체 만남)</a>
							</div>
							<div class="panel-body">
								<a href="randomRequestedShow">Random meet(랜덤 만남)</a>
							</div>
							<div class="panel-footer"></div>
						</div>
					</div>
					<div class="col-md-10">
						<div class="container-fluid">
							<div class="row">
								<div class="col-md-12">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th>신청자 사진</th>
												<th>글제목</th>
												<th>보낸 사람 id</th>
												<th>보낸 날짜</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${list}" var="vo">

												<tr>

													<td>${vo.user_photo }</td>
													<td>${vo.meet_name }</td>
													<td>${vo.user_id }</td>
													<td>${vo.regist_date }</td>
													<!-- 						<td> -->
													<%-- 							<input type="button" class="btnOk" value="수락" data-join-idx="${ vo.meet_num }"  /> --%>
													<%-- 							<input type="button" class="btnEsc" value="거절" data-join-idx="${ vo.join_idx}"/> --%>
													<!-- 						</td> -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>




					</div>
				</div>
			</div>
		</div>
	</div>




	<h1>나의 등록 현황</h1>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6">
				<h3 class="text-info">나의 등록현황</h3>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>내 사진</th>
							<th>내 id</th>
							<th>내 파트너 이름</th>
							<th>나의 주 카테고리</th>
							<th>나의 서브 카테고리</th>
							<th>등록 만남 지역</th>
							<th>나의 만남 상태</th>
						</tr>
					</thead>
					<tbody>


						<tr>

							<td>${dto.user_photo }</td>
							<td>${dto.meet_writer }</td>
							<td>${dto.meet_partner}</td>
							<td>${dto.main_category_name }</td>
							<td>${dto.category_name }</td>
							<td>${dto.loc_name }</td>
							<td>${dto.state_name }</td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h3 class="text-primary">나의 신청현황</h3>
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>내가 신청한 사람</th>
							<th>신청 DATE</th>
							<th>수락 여부</th>
							<th>신청유저 성별 </th>
						</tr>
					</thead>
					<c:forEach items="${ dto2 }" var="dto2">
						<tr>

							<td>${dto2.meet_writer }</td>
							<td>${dto2.regist_date}</td>
							<td>${dto2.accept_yn }</td>
							<td>${dto2.gender_name }</td>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
	</div>

	<!-- String user_id (String)session.getAttribute("user_id"); -->
	<!-- 	<div class="container-fluid"> -->
	<!-- 		<div class="row"> -->
	<!-- 			<div class="col-md-12"> -->
	<%-- 					${dto.meet_writer} --%>

	<%-- <%-- 				<c:if test="${dto.state_name eq '모집대기중'}"> --%>

	<!-- <!-- 					<button type="button" id="requestedShowBtn" class="btn btn-default"> -->

	<!-- <!-- 						나에게 신청한 사람들 상세보기</button> -->

	<%-- <%-- 				</c:if> --%>

	<%-- <%-- 				<c:if test="${dto.state_name eq '만남중'}"> --%>

	<!-- <!-- 					<button type="button" id="completeBtn" class="btn btn-default"> -->

	<!-- <!-- 						매칭완료</button> -->

	<%-- <%-- 				</c:if> --%>

	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<script>
		$(document).ready(function() {
			$('#requestedShowBtn').click(function() {
				location.href = "requestMatching"
			});
		});

		$(document).ready(function() {
			$('#completeBtn').click(function() {
				alert("매칭완료 되었습니다.");
				location.href = "/registShow/completeMatching"
			});
		});
	</script>
</body>
</html>
<%@ include file="../include/footer.jsp"%>