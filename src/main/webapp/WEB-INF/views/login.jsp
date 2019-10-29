<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	$(function () {
		$('#pw').on('keydown',function(e){
			if(e.keyCode==13){
				$('#btnsubmit').trigger("click");
			}
		});
		$('#btnsubmit').click(function() {
			var id=$('#id').val();
			var password=$('#pw').val();
			id=id.trim();
			password=password.trim();
			//console.log("'"+id+"','"+password+"'");
			if(id != '' && password != ''){
				$('#logForm').submit();
			}
			else{
				$('#result').empty();
				$('#result').append("아이디 또는 비밀번호를 입력해주세요.");
				
			}
		})
	});
</script>


<div class="container"  align="center">
	<H1>로그인</H1>
	
<!-- 	<div id="result" style="color:red"></div> -->
	<form action="/login" method="post" class="form-signin" id="logForm">
		<table>
			<tr>
				<td><input type="text" id="id" name="user_id" class="form-control"
					placeholder="아이디" required/>
			</tr>
			<tr>
				<td><input type="password" id="pw" name="user_pw" class="form-control"
					placeholder="비밀번호" required/>
			</tr>
			<tr>
				<td align="center">
					<input type="button" class="btn btn-success" id="btnsubmit" value="로그인" />
					<a href="signIt" class="btn btn-default">가입</a>
				</td>
			</tr>
		</table>
	</form>
	<label>${ re }</label>
</div>
<%@include file="include/footer.jsp"%>