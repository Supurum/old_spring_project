<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../include/header.jsp" %>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-1">
			<ul class="nav nav-stacked nav-tabs">
				<c:forEach items="${sub_category_list}" var="list">
					<li>
						<a href="subCategory?category_name=${list.category_name }">
							${list.category_name }
						</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="col-md-6">
			<div class="container-fluid">
			<c:if test="${list != null }">
			<c:forEach begin="0" end="${ list.size() -1}" step="2" varStatus="status">
			<div class="row">
				<div class="col-md-3">
					<c:choose>
					<c:when test="${list.get(status.index).user_photo eq null }">
						<a class="partnerInfo" href="/partnerInfo?category_name=전체&page=${pageMaker.cri.page }&user_id=${list.get(status.index).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index).user_photo }"  width="100"/></a>
					</c:when>
					<c:otherwise>
						<a class="partnerInfo" href="/partnerInfo?category_name=전체&page=${pageMaker.cri.page }&user_id=${list.get(status.index).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index).user_photo }"  width="100"/></a>
					</c:otherwise>
					</c:choose>
				</div>
				<div class="col-md-3">
					이름 : ${list.get(status.index).user_id}<br/>
					나이 : ${list.get(status.index).user_age}<br/>
					지역 : ${list.get(status.index).loc_name}<br/>
					찾는만남 : ${list.get(status.index).category_name}
				</div>
				<c:if test="${ not empty status.index and (status.index + 1) lt list.size() }">
				<div class="col-md-3">
					<c:choose>
					<c:when test="${list.get(status.index).user_photo eq null }">
						<a class="partnerInfo" href="/partnerInfo?category_name=전체&page=${pageMaker.cri.page }&user_id=${list.get(status.index+1).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index + 1).user_photo }"  width="100"/></a>
					</c:when>
					<c:otherwise>
						<a class="partnerInfo" href="/partnerInfo?category_name=전체&page=${pageMaker.cri.page }&user_id=${list.get(status.index+1).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index + 1).user_photo }"  width="100"/></a>
					</c:otherwise>
					</c:choose>
				</div>
				<div class="col-md-3">
					이름 : ${list.get(status.index + 1).user_id}<br/>
					나이 : ${list.get(status.index + 1).user_age}<br/>
					지역 : ${list.get(status.index + 1).loc_name}<br/>
					찾는만남 : ${list.get(status.index + 1).category_name}
				</div>
				</c:if>
			</div>
			</c:forEach>
			</c:if>
</div>
		</div>
		<div class="col-md-3">
		</div>
	</div>
	<%-- <div class="text-center">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				$laquo;
			</c:if>
			<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
				<c:out value="${pageMaker.cri.page == idx?'class=active':''}"/>
				${idx }
			</c:forEach>
			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				$raquo;
			</c:if>
		</ul>
	</div> --%>
	<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
						
						<c:if test="${ pageMaker.prev }">
							<li><a href="selectAll?page=${ pageMaker.startPage - 1 }">&laquo;</a></li>
						</c:if>
						
						<c:forEach var="idx" 
							begin="${ pageMaker.startPage }" 
							end="${ pageMaker.endPage }">
							<li
								<c:if test="${ pageMaker.cri.page == idx }">
								class="active"
								</c:if>
							><a href="selectAll?page=${ idx }">${ idx }</a></li>
						</c:forEach>
						
						<c:if test="${ pageMaker.next }">
							<li><a href="selectAll?page=${ pageMaker.endPage + 1 }">&raquo;</a></li>
						</c:if>
						
						</ul>
					</div>
				</div>
</div>
<script>
$(document).ready(function() {
	$('.partnerInfo').click(function(e) {
		e.preventDefault();
		var sId = '${sessionScope.id}';
		if (sId == null || sId == '') {
			alert('로그인 후 사용하세요.');
			location.href = '/login';
			return;
		}
		
		location.href = $(this).attr('href');
	});
});
</script>
<%@ include file="../include/footer.jsp" %>