<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h2>죄송합니다. 매칭에 실패했습니다.</h2>
	<h2>${ message }</h2>
	<a href="/meetRegi">랜덤매칭 등록</a>
	<a href="/ys/random/randommatch">매칭 페이지로</a>
	<a href="/intro">메인 페이지로</a>
	
</body>
</html>
<%@include file="../../include/footer.jsp"%>