<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">									
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>									
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							번호
						</th>
						<th>
							글번호
						</th>
						<th>
							요청내용
						</th>
						<th>
							요청내용
						</th>
						<th>
							보낸사람
						</th>
						<th>
							보낸 날짜
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>
							${list.join_idx }
						</td>
						<td>
							${list.meet_num }
						</td>
						<td>
							신청합니다
						</td>
						<td>
							${list.user_id }
						</td>
						<td>
							${list.regist_date }
						</td>
						<td>
							<input type="button" id="btnOk" value="수락"/>
							<input type="button" id="btnEsc" value="거절"/>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$(document).ready(function(){
		
		$("#btnOk").click(function(){
			
		});
		
		$("#btnEsc").click(function(){
			
		});
		
	});
</script>