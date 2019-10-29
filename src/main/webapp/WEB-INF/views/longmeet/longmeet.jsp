<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp" %>
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
$(document).ready(function(){
	var session = '${sessionScope.id}';
	if(session==null || session==""){
		alert('로그인후이용가능한페이지입니다.');
		location.href = "/login";
	});
</script>	
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>긴 만남 데이트 ☆	 </h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4">
						<div class="thumbnail">
							<img alt="Bootstrap Thumbnail First"
								src="http://lorempixel.com/output/people-q-c-600-200-1.jpg" />
						
						</div>
						<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			 
			<button type="button" class="btn btn-default"></a>
				<a class="btn btn-primary" href="/longmeet/messageBox">쪽지함</a>
			</button>
			
		</div>
		
		<button type="button" class="btn btn-default"></a>
				<a class="btn btn-primary" href="/longmeet/registShow"> 매칭현황 보기 </a>
			</button>

	</div>
</div>
					</div>
					<div class="col-md-4">
						<div class="thumbnail">
							<img alt="Bootstrap Thumbnail Second"
								src="http://lorempixel.com/output/city-q-c-600-200-1.jpg" />
							<div class="caption">
								<div class="box-body">

									<h3>이번  매칭 대기 회원  ~~▽</h3>
									<table class="table table-bordered">
										<tr>
												<th>사진</th>
												<th>id</th>
												<th>이름</th>
												<th>나이</th>
												<th>성별</th>
												<th>종교</th>
												<th>지역</th>
											</tr>
										<c:forEach items="${ list }" var="MatchUserDTO">
													<tr>
													<td>${MatchUserDTO.user_photo}</td>
													<td><a href="/longmeet/matchRegist">&$user_id={MatchUserDTO.user_id}</a></td>
													<td>${ MatchUserDTO.user_name }</td>
													<td>${MatchUserDTO.user_age}</td>
													<td>${MatchUserDTO.gender_name}</td>
													<td>${MatchUserDTO.religion_name}</td>
													<td>${MatchUserDTO.loc_name}</td>
													
												</tr>
										</c:forEach>

									</table>
											<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<ul class="pagination">
				<li>
					<a href="#">Prev</a>
				</li>
				<li>
					<a href="#">1</a>
				</li>
				<li>
					<a href="#">2</a>
				</li>
				<li>
					<a href="#">3</a>
				</li>
				<li>
					<a href="#">4</a>
				</li>
				<li>
					<a href="#">5</a>
				</li>
				<li>
					<a href="#">Next</a>
				</li>
			</ul>
		</div>
	</div>
</div>
					</div>
				</div>
									<a class="btn btn-primary" href="/longmeet/list">긴 만남 리스트 목록으로 가기★</a> <a
										class="btn" href="#">콕 찔러보기</a>
									</p>
								</div>
							</div>
						</div>
						<div class="col-md-4">
							<div class="thumbnail">
								<img alt="Bootstrap Thumbnail Third"
									src="http://lorempixel.com/output/sports-q-c-600-200-1.jpg" />
								<div class="caption">
									<div class="box-body">

										<table class="table table-bordered">
											<tr>
												<th>아이디</th>
												<th>나이</th>
												<th>성별</th>
												<th>지역</th>
												<th style="width: 40px">VIEWCNT</th>
											</tr>
											<!-- 										성별: -->
											<!-- 										<select id="gender"> -->
											<%-- 											<c:forEach var="i" begin="0" end=""> --%>
											<!-- 												 gender.length -->
											<%-- 												<option value="${gender.GENDER_NUM}">${gender.GENDER_NAME}</option> --%>
											<%-- 											</c:forEach> --%>
											<!-- 										</select> -->
											<c:forEach items="${ list }" var="MatchUserDTO">

												<tr>
<%-- 													<td>${ UserVO.user_id }</td> --%>
<%-- 													<td>${UserVO.user_age}</td> --%>
													<%-- 												<td>${ UserVO.USER_AGE }</td> --%>
													<%-- 												<td>${ UserVO.USER_GENDER}</td> --%>
													<%-- 												<td>${ UserVO.USER_ADDR }</td> --%>
												</tr>
											</c:forEach>

										</table>
										<p>
											<a class="btn btn-primary" href="#">요청하기</a> <a class="btn"
												href="#">♥콕 찔러보기</a>
										</p>
									</div>
								</div>
							</div>
					</div>
				</div>
			</div>
</body>
</html>

<%@ include file="../include/footer.jsp" %>