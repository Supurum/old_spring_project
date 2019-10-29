<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
var session = '${sessionScope.id}';
if(session==null || session==""){
	alert('로그인후이용가능한페이지입니다.')
	location.href = "/login";
}
</script>
</head>
<body>
randommath.jsp
<!-- 
	SESSION에서 로그인 한 사람의 ID를 얻어 온다. 임시로 ID라고 표시
	만날 성별은 TBL_GENDER에서 목록을 가져온다. 임시로 gender라고 표시 
	-->
	<form action="randommatch" method="post">
		<!-- <input type="hidden" name="id" value="${ID}" /> -->
		목적: 
		<select name="aim">
			<c:forEach items="${ categoryList }" var="categoryList">
				<option value="${ categoryList.category_num }">${ categoryList.category_name }</option>
			</c:forEach>
		</select><!-- 짧은 만남의 목적, 긴만남과 랜덤만남으로 분류-->
		<input type="submit" value="랜덤 만남">
		<!-- 
			매칭 신청자(A)의 ID와 목적을 받아 ID로 A의 나이 성별을 얻은 뒤 만남 테이블에서 A의 목적과 A의 성별과 목적 성별이 
			같은 만남 목록을 구한 후 목록에서 매칭 등록자(B)의 ID를 얻어 B의 나이를 얻은 후 A와 B의 나이 차이가 5살 이하인 
			경우에서 랜덤으로 1명을 선택하게 한다.
		 -->
		 <!-- 
		 	1.SELECT USER_AGE,USER_GENDER FROM TBL_USER WHERE USER_ID = (ID PARAM);
		 	2.SELECT * FROM 
		 	(SELECT M.*,U.* FROM TBL_USER U , TBL_MEET M WHERE U.USER_ID = M.WRITER)
		 	WHERE MEET_SUB_CATEGORY= (AIM PARAM) AND MEET_TARGET_GENDER= (1 QUERY.USER_GENDER) AND( USER_AGE<1.USER_AGE+5 AND USER_AGE>1.USER_AGE-5)
		 	
		 	LIST얻은 후 LENGTH로 랜덤 한 후, 한 행만 리턴.
		  -->
</form>
</body>
</html>
<%@include file="../../include/footer.jsp"%>