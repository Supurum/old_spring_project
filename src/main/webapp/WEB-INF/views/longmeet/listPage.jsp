<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>

<!-- <script> -->
<!-- // 	function printPage(pageMaker){ -->
<!-- // 		var str=''; -->
<!-- // 		if(pageMaker.prev == true){ -->
<!-- // 			str +='<li><a href="' + (pageMaker.startPage-1)+ '">&laquo;</li>'; -->
<!-- // 		} -->
		
<!-- // 		for(var i = pageMaker.startPage; i<= pageMaker.endPage; i++){ -->
<!-- // 			str += '<li><a href="' + i +'">' + i +''</a></li>'; -->
<!-- // 		}	 -->
		
<!-- // 		if(pageMaker.next ==true){ -->
<!-- // 			str += '<li><a href="' +(pageMaker.endPage +1)+"'>&raquo;</li>'; -->
<!-- // 		} -->
<!-- // 		$('#pagination').html(str); -->
<!-- // 	} -->

<!-- </script> -->



<body>
	<h1>매칭 등록 페이지</h1>
	<div class="container-fluid">
	
	<c:forEach begin="0" end="${ listPage.size()-1}" step="2" varStatus="status" >
	<div class="row">
		<div class="col-md-6">
			
							${listPage.get(status.index).user_photo }<br />
							${listPage.get(status.index).meet_name }<br />
							${listPage.get(status.index).category_name }<br />
							${listPage.get(status.index).loc_name }<br />
							<a href="#">${listPage.get(status.index).meet_writer }</a><br />
				
		</div>

		<div class="col-md-6">
			${listPage.get(status.index+1).user_photo }<br />
					${listPage.get(status.index+1).meet_name }<br /> 
					${listPage.get(status.index+1).category_name }<br /> 
					${listPage.get(status.index+1).loc_name }<br />
					<a href="#">${listPage.get(status.index+1).meet_writer }</a><br />
				
		</div>

	</div>

 						</c:forEach> 
	
	
		
	
	<div class="box-footer">
		<div class="text-center">
			<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li> <a href="listPage/${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
			</c:if>
			<c:forEach var="idx" begin="${pageMaker.startPage }" end="${pageMaker.endPage }">
				<li
					<c:out value ="${pageMaker.cri.page == idx?'class = active':'' }"/>>
					<a href = "listPage${pageMaker.makeSearch(idx)}" >${idx}</a>
					</li>
					</c:forEach>
					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="listPage${ pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
			</c:if>
			</ul>
		</div>
	</div>
</div>
	
	
<!-- 	<div class="container-fluid"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-12"> -->
<!-- 				<img alt="Bootstrap Image Preview" -->
<!-- 					src="http://lorempixel.com/140/140/" /> -->
<!-- 				<div class="caption"> -->
<!-- 					<div class="box-body"> -->

<!-- 						<h3>이번 매칭 대기 회원 ~~▽</h3> -->
<!-- 												<table class="table table-bordered"> -->
<!-- 													<tr> -->
<!-- 														<th>사진</th> -->
<!-- 														<th>id</th> -->
<!-- 														<th>이름</th> -->
<!-- 														<th>나이</th> -->
<!-- 														<th>성별</th> -->
<!-- 														<th>종교</th> -->
<!-- 														<th>지역</th> -->

<!-- 													</tr> -->
<%-- 						<div>${listPage }${listPage.size() }</div> --%>
<%-- 																<c:forEach items=" ${listPage}"	 var="MatchRegisterVO">						 --%>
<%-- 						<c:forEach begin="0" end="${ listPage.size()-1}" step="2" --%>
<%-- 							varStatus="status"> --%>
<%-- 											${listPage.get(status.index).user_photo }<br /> --%>
<%-- 											${listPage.get(status.index).meet_name }<br /> --%>
<%-- 											${listPage.get(status.index).category_name }<br /> --%>
<%-- 											${listPage.get(status.index).loc_name }<br /> --%>
<%-- 											${listPage.get(status.index).meet_writer }<br /> --%>



<%-- 							<c:if --%>
<%-- 								test="${not empty status.index and(status.index +1)lt list.size()}"> --%>
<%-- 											${listPage.get(status.index+1).user_photo }<br /> --%>
<%-- 											${listPage.get(status.index+1).meet_name }<br /> --%>
<%-- 											${listPage.get(status.index+1).category_name }<br /> --%>
<%-- 											${listPage.get(status.index+1).loc_name }<br /> --%>
<%-- 											${listPage.get(status.index+1).meet_writer }<br /> --%>

<%-- 							</c:if> --%>
<%-- 						</c:forEach> --%>

<!-- 												</table> -->
<!-- 					</div> -->

<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
</body>
</html>