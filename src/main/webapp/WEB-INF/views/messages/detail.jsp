<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-5">
			<input type="button" id="btnList" value="목록" class="btn btn-info"/>
			<input type="button" id="btnDel" value="삭제" class="btn btn-info"/>
			<input type="button" id="btnReply" value="답장" class="btn btn-info"/><br/> 
		</div>
	</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2">
			<ul class="nav nav-tabs nav-stacked">
				<li>
					<a href="/messages/list/targetid/1">받은쪽지함</a>
				</li>
				<li>
					<a href="/messages/list/sender/1">보낸쪽지함</a>
				</li>
				
				<li class="active">
					<a href="/messages/write">쪽지쓰기</a>
				</li>
			</ul>
		</div>
		<div class="col-md-1">
		</div>
		<div class="col-md-5" style="border: 1px solid gray; ">
			<div class="form-group">				 
				<label>
					보낸 사람 : ${dto.user_nickname}(${dto.sender})
				</label>
			</div>
			
			<div class="form-group">				 
				<label>
					받은 시간 : ${dto.senddate}
				</label>
			</div>
			<div class="form-group"> 
				 
				<label for="message">
					내용 
				</label> 
				<textarea name="message" class="form-control" readonly="readonly" rows="10"
					 style="width:600px; resize: none;">${dto.message}</textarea>
			</div> 
		</div>
		<div class="col-md-4">
		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	
	$("#btnDel").click(function(){	
		location.href = "/messages/delete/${dto.msg_num}";
	});
	
	$("#btnReply").click(function(){	
		location.href = "/messages/reply/${dto.sender}";
	});
	
	$("#btnList").click(function(){	
		location.href = "/messages/list/${type}/1";
	});
	
});
</script>
<%@ include file="../include/footer.jsp" %>