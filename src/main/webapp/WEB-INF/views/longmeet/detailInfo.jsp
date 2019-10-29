<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- // $(document).ready(function(){ // $("#requestBtn").click(function(){ -->
<!-- // location.href ="request"; // }); // }); // -->
<!-- $(document).ready(function(){ // $("#likeBtn").click(function(){ // -->
<!-- location.href ="#"; // }); // }); -->
<script>
$(document).ready(function(){


	// 요청(참가)하기 눌렀을때
	$('#requestBtn').click(function(){
// 		data-meet-num
		
		var meet_num = $(this).attr('data-meet-num');
		console.log('meet_num:' + meet_num);
		var meet_writer = '$(dto.user_id)';
		//1차확인 값두개넘겨오는거확인
		console.log(meet_num)
		console.log(meet_writer)
		console.log('meet_num:' + meet_num);

		var url = '/registShow/meet_request';
		var data = {
			'meet_num' : meet_num,
			'meet_writer'  : '${ dto.user_id}'
			
		};
// 		$.get(url, data, function(receivedData) {
// 			console.log('receivedData:' + receivedData);
// 		});
	
		$.post(url,data,function(result){
			
			if(result == 'FAIL' ){
				alert("이미 처리 되었습니다.")
			}else if(result =='SUCCESS' ){
				alert("처리 되었습니다 .");
			}
// 			console.log(result);
	}); // post 
	}); //$click. function
});
</script>
</head>

<body>
	
	<h1>까까 페이지</h1>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<img alt="Bootstrap Image Preview"
					src="http://lorempixel.com/140/140/" /></br> <span
					class="label label-default">사진: </span>${dto.user_photo}</br> <span
					class="label label-default">id: </span>${dto.user_id}</br> <span
					class="label label-default">회원 이름:</span>${dto.user_name}</br> <span
					class="label label-default">나이:</span>${dto.user_age}</br> <span
					class="label label-default">회원 성별: </span>${dto.gender_name}</br> <span
					class="label label-default">종교 : </span>${dto.religion_name}</br> <span
					class="label label-default">지역 : </span>${dto.loc_name}</br>

			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">

				<button type="button" button id="requestBtn" class="btn btn-default"
					data-meet-num="${ dto.meet_num }">DATE요청하기</button>
				<a href="list" button type="button" class="btn btn-default">목록으로</a>

				</button>
				<a href="messageBox" button id="likeBtn">좋아요☆
					</button>
			</div>

		</div>
	</div>
</body>
</html>
<%@ include file="../include/footer.jsp"%>