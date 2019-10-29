<%@page import="com.pjt.domain.ys.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="../include/header.jsp"%>

<style> 
#panel, #flip {
    padding: 5px;
    text-align: center;
    background-color: #e5eecc;
    border: solid 1px #c3c3c3;
}

#panel {
    padding: 50px;
}

.content {
	margin-left: 100px;
	margin-right: 100px;
}
</style>

<section class="content">
	<div class="row">
		<div class="col-md-12">

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title" style="display:inline;">전체 글 목록</h3>
 					<c:if test="${ sessionScope.id != null }">
						<input type="button" class="btn btn-success" id="btnWrite" value="글쓰기"/>
 					</c:if>
					<select id="selectLine" style="display:inline;">
						<c:forEach var="i" begin="5" end="20" step="5">
							<option 
								<c:if test="${i eq pageMaker.cri.perPageNum }">
								selected="selected"
								</c:if>
							value="${i}">${i}줄씩 보기</option>
						</c:forEach>
					</select>
				</div>
				<div class="box-body" >
					<div id=flip>공지사항</div>
					<div id=panel>내용</div>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 60px">번호</th>
							<th style="width: 900px">제목</th>
							<th style="width: 250px">작성자</th>
							<th>날짜</th>
							<th style="width: 40px">조회</th>
						</tr>
						
						<c:forEach items="${ list }" var="boardVO">
							<tr>
								<td style="width: 60px">${ boardVO.tbl_bno }</td>
								<td style="width: 900px"><a href="/board/read${pageMaker.makeSearch(pageMaker.cri.page)}
								&tbl_bno=${boardVO.tbl_bno}">${ boardVO.tbl_title }[${boardVO.tbl_replycnt }]</a></td>
								<td style="width: 250px">${ boardVO.tbl_writer }</td>
								<td><fmt:formatDate value="${ boardVO.tbl_regdate }" pattern="yyyy-MM-dd HH:mm"/> </td>
								<td style="width: 40px" class="badge">${ boardVO.tbl_viewcnt }</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
						
						<c:if test="${ pageMaker.prev }">
							<li><a href="${ pageMaker.startPage - 1 }">이전</a></li>
						</c:if>
						
						<c:forEach begin="${ pageMaker.startPage }" end="${ pageMaker.endPage }" var="idx">
							<li
								<c:if test="${ pageMaker.cri.page == idx }">class="active"</c:if>>
								<a href="${ idx }">${ idx }</a>
							</li>
						</c:forEach>
						
						<c:if test="${ pageMaker.next }">
							<li><a href="${ pageMaker.endPage + 1 }">다음</a></li>
						</c:if>
						
						</ul>
					</div>
					<div class="text-center">
						<form role="form" id="searchForm">
							<input type="hidden" name="page" value="${ pageMaker.cri.page }">
							<input type="hidden" name="perPageNum" value="${ pageMaker.cri.perPageNum }">
							<select name="searchType">
								<option value="tc"
									<c:out value="${ pageMaker.cri.searchType eq 'tc' ? 'selected' : '' }"/>
									>제목 + 내용
								</option>
								<option value="t"
									<c:out value="${ pageMaker.cri.searchType eq 't' ? 'selected' : '' }"/>
									>제목만
								</option>
								<option value="w"
									<c:out value="${ pageMaker.cri.searchType eq 'w' ? 'selected' : '' }"/>
									>작성자
								</option>
							</select>
							<input type="text" name="keyword" value="${ pageMaker.cri.keyword }"/>
							<input type="button" class="btn btn-info" id="btnSearch" value="검색"/>
						</form>
					</div>
				</div>
				<!-- /.box-footer-->
			</div>
		</div>

	</div>
</section>

<form id="jobForm">
	<input type="hidden" name="page" value="${ pageMaker.cri.page }"/>
	<input type="hidden" name="perPageNum" value="${ pageMaker.cri.perPageNum }"/>
	<input type="hidden" name="searchType" value="${ pageMaker.cri.searchType }"/>
	<input type="hidden" name="keyword" value="${ pageMaker.cri.keyword }"/>
</form>

<script>
$(document).ready(function() {
	var result = '${msg}';
	var jobForm = $('#jobForm');
	var searchForm = $('#searchForm');
	
	if (result == 'success') {
		alert('처리가 완료되었습니다.');
	}
	
	$('.pagination > li > a').click(function(e) {
		e.preventDefault();
		var targetPage = $(this).attr('href');
		
		jobForm.find('[name=page]').val(targetPage);
		jobForm.attr('action', '/board/list').attr('method', 'get');
		jobForm.submit();
		
	});
	
	$('#selectLine').change(function() {
		var perPageNum = $(this).val();
		jobForm.find('[name=perPageNum]').val(perPageNum);
		jobForm.find('[name=page]').val(1);
		jobForm.attr('action', '/board/list').attr('method', 'get');
		jobForm.submit();
	});
	
	$('#btnWrite').click(function() {
		location.href = 'register';
	});
	
	$('#btnSearch').click(function() {
		searchForm.submit();
	});
	
	$('#flip').on("click", function() {
		$('#panel').slideToggle("show");
	});
});
</script>

<%@include file="../include/footer.jsp"%>
