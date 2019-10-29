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
<script>
$(document).ready(function(){
	$(".viewUser").click(function(e){
		var session = '${sessionScope.id}';
		if(session==null || session==""){
			alert('로그인후에 이용 가능한 페이지입니다.')
			e.preventDefault();
			console.log("사용자보기");
			location.href="/login";
		}
		
	});
});



</script>
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
	<h1>긴 만남 리스트 페이지</h1>
	<div class="container-fluid">

		<c:forEach begin="0" end="${ longUserList.size()-1}" step="2"
			varStatus="status">
			<div class="row">
				<div class="col-md-6">

					<img
						src="/displayfile?fileName=${longUserList.get(status.index).user_photo}"
						width="100";>${longUserList.get(status.index).user_photo }<br />
					<a class="viewUser" 
						href="detailInfo?user_id=${longUserList.get(status.index).meet_writer}&page=${pageMaker.cri.page}">${longUserList.get(status.index).meet_writer }</a><br />
					${longUserList.get(status.index).meet_name }<br />
					${longUserList.get(status.index).category_name }<br />
					${longUserList.get(status.index).loc_name }<br />

				</div>
				
				<c:if test="${status.index + 1 < longUserList.size()}">

				<div class="col-md-6">
					<img src="/displayfile?=${longUserList.get(status.index+1).user_photo}"
						width="100";>${longUserList.get(status.index+1).user_photo }<br />
					<a class="viewUser" href="detailInfo?user_id=${longUserList.get(status.index+1).meet_writer}&page=${pageMaker.cri.page}">${longUserList.get(status.index+1).meet_writer } 
					
					</a><br /> ${longUserList.get(status.index+1).meet_name }<br />
					${longUserList.get(status.index+1).category_name }<br />
					${longUserList.get(status.index+1).loc_name }<br />

				</div>
				</c:if>

			</div>

		</c:forEach>




		<div class="box-footer">
			<div class="text-center">
				<ul class="pagination">
					<c:if test="${pageMaker.prev }">
						<li><a
							href="list${pageMaker.makeSearch(pageMaker.startPage -1)}">&laquo;</a></li>
					</c:if>
					<c:forEach var="idx" begin="${pageMaker.startPage }"
						end="${pageMaker.endPage }">
						<li
							<c:out value ="${pageMaker.cri.page == idx?'class = active':'' }"/>>
							<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
						</li>
					</c:forEach>
					<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
						<li><a
							href="list${ pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>



</body>
</html>
<%@ include file="../include/footer.jsp"%>