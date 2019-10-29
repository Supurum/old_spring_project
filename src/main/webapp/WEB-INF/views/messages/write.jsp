<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

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
		<div class="col-md-5" style="border: 1px solid gray;">
			<form role="form" action="/messages/writePost" method="post">
				<div class="form-group">
					 
					<label for="targetid">
						받는사람
					</label>
					<input type="text" class="form-control" id="targetid" name="targetid"  style='width:200px'/>
				</div>
				<div class="form-group"> 
					 
					<label for="message">
						내용
					</label> 
					<textarea name="message" class="form-control" id="message" rows="10" 
						 style="width:600px; resize: none;"></textarea>
				</div>
				
				<button type="submit" class="btn btn-primary">
					보내기
				</button>
				
				<input type="hidden" name="sender" value="${sessionScope.id}"/>
			</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
</div>
<%@ include file="../include/footer.jsp" %>