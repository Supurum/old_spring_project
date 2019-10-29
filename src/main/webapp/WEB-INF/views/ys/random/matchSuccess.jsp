<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table>
		<tr>
<%-- 			<c:forEach items="${ list }" var="list" > --%>
				<!-- 내정보 -->
				<td>
					<table>
						<tr>
							<td><img src="/displayFile?fileName="${ list[0].user_photo }" alt="Attachment"></td>
						</tr>
						<tr>
							<td>${ list[0].user_name }</td>
						</tr>
						<tr>
							<td>${ list[0].user_age }</td>
						</tr>
<!-- 						<tr> -->
<%-- 							<td>${ list[0].user_gender }</td> --%>
<!-- 						</tr> -->
					</table>
				</td>
				<td><img src="/displayFile?fileName=/common/heart.png" alt="Attachment"></td>
				<td>
					<table>
						<tr>
							<td><img src="/displayFile?fileName="${ list[1].user_photo }" alt="Attachment"></td>
						</tr>
						<tr>
							<td>${ list[1].user_name }</td>
						</tr>
						<tr>
							<td>${ list[1].user_age }</td>
						</tr>
<!-- 						<tr> -->
<%-- 							<td>${ list[1].user_gender }</td> --%>
<!-- 						</tr> -->
					</table>
				</td>
<%-- 			</c:forEach> --%>
		</tr>
		<tr>
			<td colspan="3"><input type="button" value="만날 약속하기" /></td>
		</tr>
	</table>
</body>
</html>
<%@include file="../../include/footer.jsp"%>