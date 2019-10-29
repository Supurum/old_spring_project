<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login.jsp"%>
<script>
var session = '${sessionScope.id}';
if(session==null || session==""){
	alert('로그인후이용가능한페이지입니다.')
	location.href = "/login";
}
$('form').attr('action','cert');
$('a').css('display','none');
// $('h1').css('display','none');
$('#id').attr('type','hidden');
$('h1').text('비밀번호 확인');
$('#id').val(session);
$('#btnsubmit').val('확인');

</script>