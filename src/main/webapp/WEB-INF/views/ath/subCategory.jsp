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
		
			<table class="table">
				<thead>
					<tr>
						<th>
							사진
						</th>
						<th>
							정보
						</th>
						<th>
							사진
						</th>
						<th>
							정보
						</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${list.size() > 0 }">
				<c:forEach begin="0" end="${ list.size() -1}" step="2" varStatus="status">
				<tr class="danger">
				<td>
					<c:choose>
					<c:when test="${list.get(status.index).user_photo eq null }">
						<a href="/partnerInfo?category_name=술&page=${pageMaker.cri.page }&user_id=${list.get(status.index).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index).user_photo }"  width="100"/></a>
					</c:when>
					<c:otherwise>
						<a href="/partnerInfo?category_name=술&page=${pageMaker.cri.page }&user_id=${list.get(status.index).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index).user_photo }"  width="100"/></a>
					</c:otherwise>
					</c:choose>
				</td>
				<td>이름 : ${list.get(status.index).user_id}<br/>
					나이 : ${list.get(status.index).user_age}<br/>
					지역 : ${list.get(status.index).loc_name}<br/>
					찾는만남 : ${list.get(status.index).category_name}</td>
				
				
				<c:if test="${ not empty status.index and (status.index + 1) lt list.size() }">
				<td>
					<c:choose>
					<c:when test="${list.get(status.index+1).user_photo eq null }">
						<a href="/partnerInfo?category_name=술&page=${pageMaker.cri.page }&user_id=${list.get(status.index).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index+1).user_photo }"  width="100"/></a>
					</c:when>
					<c:otherwise>
						<a href="/partnerInfo?category_name=술&page=${pageMaker.cri.page }&user_id=${list.get(status.index).user_id}">
						<img src="/displayfile?fileName=${list.get(status.index+1).user_photo }"  width="100"/></a>
					</c:otherwise>
					</c:choose>
				</td>
				<td>
					이름 : ${list.get(status.index+1).user_id}<br/>
					나이 : ${list.get(status.index+1).user_age}<br/>
					지역 : ${list.get(status.index+1).loc_name}<br/>
					찾는만남 : ${list.get(status.index+1).category_name}
				</td>
				</c:if>
				  
				</tr>
				</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
		<div class="col-md-3">
		</div>
	</div>
	<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
						
						<c:if test="${ pageMaker.prev }">
							<li><a href="selectAlcohol?category_name=술&page=${ pageMaker.startPage - 1 }">&laquo;</a></li>
						</c:if>
						
						<c:forEach var="idx" 
							begin="${ pageMaker.startPage }" 
							end="${ pageMaker.endPage }">
							<li
								<c:if test="${ pageMaker.cri.page == idx }">
								class="active"
								</c:if>
							><a href="selectAlcohol?category_name=술&page=${ idx }">${ idx }</a></li>
						</c:forEach>
						
						<c:if test="${ pageMaker.next }">
							<li><a href="selectAlcohol?category_name=술&page=${ pageMaker.endPage + 1 }">&raquo;</a></li>
						</c:if>
						
						</ul>
					</div>
				</div>
</div>
<%@ include file="../include/footer.jsp" %>