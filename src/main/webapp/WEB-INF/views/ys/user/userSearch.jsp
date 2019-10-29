<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../include/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
// 	function sw() {
// 		var i = $('#searchChar').val();
// 		switch (i) {
// 		case 'a':
// 			$('#aint').attr('style', 'visibility:visible');
// 			break;
// 		case 'l':
// 			$('#lint').attr('style', 'visibility:visible');
// 			break;
// 		case 'r':
// 			$('#rint').attr('style', 'visibility:visible');
// 			break;
// 		}
// 	}
	$(function() {
// 		sw();
// 		function reset() {
// 			$('#aint').attr('style', 'visibility:hidden');
// 			$('#lint').attr('style', 'visibility:hidden');
// 			$('#rint').attr('style', 'visibility:hidden');
// 		}
// 		$('#searchChar').on('change', function() {
// 			reset();
// 			sw();
// 		});
		$('#searchBtn').click(function() {
			$('#searchForm').submit();
		});
		$('.pagination > li > a').click(function(e) {
			e.preventDefault(); // 태그의 기본 기능 막기
			var targetPage = $(this).attr('href');

			jobForm.find('[name=page]').val(targetPage);
			jobForm.attr('action', '/ys/sboard/list').attr('method', 'get');
			jobForm.submit();

		});
		//?
		var jobForm = $('#jobForm');
		$('.pagination > li > a').click(function(e) {
			e.preventDefault(); // 태그의 기본 기능 막기
			var targetPage = $(this).attr('href');
			
			jobForm.find('[name=page]').val(targetPage);
			jobForm.attr('action', '/ys/user/userSearch').attr('method', 'get');
			jobForm.submit();
			
		});
	});
</script>
<form role="form" id="searchForm" method="get">
	<input type="hidden" name="page" value="1" /> <input
		type="hidden" name="perPageNum" value="${ pageMaker.cri.perPageNum }" />
<!-- 	<label style="margin: 0 10px;">검색</label> <select name="searchChar" -->
<!-- 		id="searchChar"> -->
<!-- 		<option value="n">-------</option> -->
<!-- 		<option value="a" -->
<%-- 			<c:out value="${ pageMaker.cri.searchChar eq 'a' ? 'selected' : '' }"/>>나이</option> --%>
<!-- 		<option value="l" -->
<%-- 			<c:out value="${ pageMaker.cri.searchChar eq 'l' ? 'selected' : '' }"/>>지역</option> --%>
<!-- 		<option value="r" -->
<%-- 			<c:out value="${ pageMaker.cri.searchChar eq 'r' ? 'selected' : '' }"/>>종교</option> --%>

<!-- 	</select> -->
	<!-- 17.11.18 -->
	<select name="aint" id="aint">
		<!-- AGE 나이 -->
		<option value="0">나이</option>
		<c:forEach begin="1" end="9" step="1" var="var">
			<option value="${var}"
				<c:if test="${pageMaker.cri.aint eq var}">selected</c:if>>${var}0대</option>
		</c:forEach>
	</select> <select name="lint" id="lint">
		<!-- LOC 지역 -->
		<option value="0">지역</option>
		<c:forEach items="${loclist}" var="list">
			<option value="${list.loc_num}"
				<c:if test="${pageMaker.cri.lint eq list.loc_num}">selected</c:if>>${list.loc_name}</option>
		</c:forEach>
	</select> <select name="rint" id="rint">
		<!-- Region 종교 -->
		<option value="0">종교</option>
		<c:forEach items="${religionlist}" var="list">
			<option value="${list.religion_num}"
				<c:if test="${pageMaker.cri.rint eq list.religion_num}">selected</c:if>>${list.religion_name}</option>
		</c:forEach>
	</select> <select name="user_gender">
		<c:forEach items="${genderlist}" var="list">
			<c:if test="${list.gender_num ne 0}">
				<option value="${list.gender_num}"
					<c:if test="${pageMaker.cri.user_gender eq list.gender_num}">selected</c:if>>${list.gender_name}</option>
			</c:if>
		</c:forEach>
	</select>
	<!-- END -->
	<input type="button" id="searchBtn" class="btn btn-info" value="Search" />
</form>
<table class="table table-bordered">
	<tr>
		<th>사진</th>
		<th>이름</th>
		<th>성별</th>
		<th>나이</th>
		<th>사는 곳</th>
		<th>종교</th>
	</tr>

	<c:forEach items="${ list }" var="user">
		<tr>
			<td>${ user.user_photo }</td>
			<td><a href="#">${ user.user_name }</a></td>
			<td>${ user.gender_name }</td>
			<td>${ user.user_age}</td>
			<td>${ user.loc_name}</td>
			<td>${ user.religion_name }</td>
		</tr>
	</c:forEach>
</table>
<div class="text-center">
	<ul class="pagination">

		<c:if test="${ pageMaker.prev }">
			<li><a href="${ pageMaker.startPage - 1 }">&laquo;</a></li>
		</c:if>

		<c:forEach var="idx" begin="${ pageMaker.startPage }"
			end="${ pageMaker.endPage }">
			<li
				<c:if test="${ pageMaker.cri.page == idx }">
								class="active"
								</c:if>><a
				href="${ idx }">${ idx }</a></li>
		</c:forEach>

		<c:if test="${ pageMaker.next }">
			<li><a href="${ pageMaker.endPage + 1 }">&raquo;</a></li>
		</c:if>
	</ul>
</div>


<form id="jobForm">
	<input type="text" name="page" 
		value="${ pageMaker.cri.page }"/>
	<input type="hidden" name="perPageNum" 
		value="${ pageMaker.cri.perPageNum }"/>
	<input type="hidden" name="searchChar" 
		value="${ pageMaker.cri.searchChar }"/>
	<input type="hidden" name="aint" 
		value="${ pageMaker.cri.aint }"/>
	<input type="hidden" name="lint" 
		value="${ pageMaker.cri.lint }"/>
	<input type="hidden" name="rint" 
		value="${ pageMaker.cri.rint }"/>
	<input type="hidden" name="user_gender" 
		value="${ pageMaker.cri.user_gender }"/>
</form>
<script id="loctemplate" type="text/x-handlebars-template">
{{#each .}}
	<option value="{{loc_num}}">{{loc_name}}</option>
{{/each}}
</script>
<script id="religiontemplate" type="text/x-handlebars-template">
{{#each .}}
	<option value="{{religion_num}}">{{religion_name}}</option>
{{/each}}
</script>
