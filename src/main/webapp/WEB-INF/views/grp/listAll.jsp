<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<html>
<head>
</head>
<body>
<div class="container-fluid">
	<h3>단체모임</h3><br/><br/>

	<div class="row">
		<div class="col-md-2">
			<ul class="nav nav-stacked nav-tabs">
				<li>
					<a href="/grp/listAll">전체목록</a>
				</li>
				<li>
					<a href="/meetRegi">모집하기</a>
				</li>
				<li>
					<a href="/grp/list">참여 가능한 목록</a>
			</ul>
		</div>
		<div class="col-md-10"> 
		<h3>전체목록</h3><br/> 
		</div>
	</div>

<%-- 	<c:forEach items="${ list}" var = "ListDTO" > --%>
	<c:if test="${list.size() > 0}">
	<c:forEach begin="0" end="${list.size() -1 }" step="2" varStatus="status">
	
		<div class="row">
			<div class="col-sm-2">
			</div>
			
			<c:choose>
				<c:when test="${list.get(status.index).user_photo != null}">
					<div class="col-sm-2">
						${list.get(status.index).user_photo }
					</div>
				</c:when>
				<c:when test="${list.get(status.index).user_photo == null}">
					<div class="col-sm-2">
						<img alt="사진 없음" src="/resources/images/1.jpg" class="img-thumbnail"/>
					</div>
				</c:when>
			</c:choose>
			
			<div class="col-md-3" style="font-size:20">
				<div class="lib-row lib-header">
		           <h4 style="font-size:20"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt; ${list.get(status.index).state_name } &gt;</b></h4>
		        </div>
		        <div class="lib-row lib-desc">
	               	${list.get(status.index).meet_name }<br/>
		        	모임 지역 : ${list.get(status.index).loc_name}<br/>
	               	작성자 : ${list.get(status.index).meet_writer }<br/>
	               	현재 모집된 인원 : ${list.get(status.index).meet_peoplenum } <br/>
	               	<fmt:formatDate value="${list.get(status.index).meet_regist_date }" pattern="yyyy-MM-dd HH:mm"/><br/>
	               	<a class="btn btn-mini" href="/grp/read/${pageMaker.cri.page}/${list.get(status.index).meet_num}">» 상세 정보</a>
	            </div>
			</div>
			
			<c:if test="${not empty status.index and (status.index + 1) lt list.size()}">
				<c:choose>
				<c:when test="${list.get(status.index + 1).user_photo != null}">
					<div class="col-sm-2">
						${list.get(status.index + 1).user_photo }
					</div>
				</c:when>
				<c:when test="${list.get(status.index + 1).user_photo == null}">
					<div class="col-sm-2">
						<img alt="사진 없음" src="/resources/images/1.jpg" class="img-thumbnail"/>
					</div>
				</c:when>
			</c:choose>
			
			<div class="col-md-3" style="font-size:20">
				<div class="lib-row lib-header">
		           <h4 style="font-size:20"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt; ${list.get(status.index + 1).state_name } &gt;</b></h4>
		        </div>
		        <div class="lib-row lib-desc">
	               	${list.get(status.index + 1).meet_name }<br/>
		        	모임 지역 : ${list.get(status.index + 1).loc_name}<br/>
	               	작성자 : ${list.get(status.index + 1).meet_writer }<br/>
	               	현재 모집된 인원 : ${list.get(status.index + 1).meet_peoplenum } <br/>
	               	<fmt:formatDate value="${list.get(status.index + 1).meet_regist_date }" pattern="yyyy-MM-dd HH:mm"/><br/>
	               	<a class="btn btn-mini" href="/grp/read/${pageMaker.cri.page}/${list.get(status.index + 1).meet_num}">» 상세 정보</a>
	            </div>
			</div>
			</c:if>
		</div><br/>
	</c:forEach>
	</c:if>
	<div class="row">
		<div class="text-center">
			<ul class="pagination">
				
				<c:if test="${pageMaker.prev }">
					<li><a href="/grp/listAll/${pageMaker.startPage - 1}">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li
						<c:if test="${pageMaker.cri.page == idx }">
						class="active"
						</c:if>
						><a href="/grp/listAll/${idx }">${idx }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<li><a href="/grp/listAll/${pageMaker.endPage + 1}">&raquo;</a></li>
				</c:if>	
			</ul>
		</div>
	</div>
</div>

</body>
</html>
<script>
	$(document).ready(function(){
		$(".btn-mini").click(function(){
			var loginId = '${sessionScope.id}'
			if(loginId == false){		
			console.log(loginId);
			 $(this).attr('href', "/login");
				alert("로그인 후 이용가능합니다.")
			}			
		});	
	});
</script>
<%@include file="../include/footer.jsp"%>