<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">									
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>									
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>	
<%@ include file="../include/header.jsp"%>
<script>
	$(document).ready(function(){
		
		
		//수락버튼
		$(".btnOk").click(function(){
			var meet_num = $(this).attr('data-join-idx');
			var parent_tr = $(this).parents('tr');
			
			data = {'meet_num' : meet_num};
// 			console.log(data);
			
			$.post('/registShow/changeY', data, function(rData) {
				if(rData == "SUCCESS"){
					alert("수락되었습니다.");
					parent_tr.fadeOut(600);
// 					parent_tr.remove();
				} else{
					alert("서버 에러");
				}
			});
		});	
// 			$.ajax({
// 				'url' : '/registShow/changeY',
// 				'data' : data,
// 				'dataType' : 'text',
// 				'type' : 'post',
// 				'success' : function(rData){
// 					if(rData == "SUCCESS"){
// 						alert("수락되었습니다.")
// 						parent_tr.remove();
// 					} else{
// 						alert("서버 에러");
// 					}
// 				}
// 			});
	
		
		//거절버튼
		$(".btnEsc").click(function(){			
			var join_idx = $(this).attr('data-join-idx');
			var parent_tr =$(this).parents('tr');
			data = { 'join_idx' : join_idx};
			console.log(data);
			$.post('/registShow/delete', data, function(rData2) {
				if(rData2 == "SUCCESS"){
					alert("삭제되었습니다.");
					parent_tr.fadeOut(600);
// 					parent_tr.remove();
				} else{
					alert("서버 에러가 생겼습니다.");
				}
			});
		});	
// 			$.ajax({
// 				'url' : '/delete',
// 				'data' : data,
// 				'dataType' : 'text',
// 				'headers' : {
// 					'Content-Type' : 'application/json',
// 					'X-Http-Method-Override' : 'POST'
// 				},
// 				'type'  : 'delete',
// 				'success' : function(rData){
// 					if (rData == 'SUCCESS') {
// 						parent_tr.remove();
// 					} else {
// 						alert('서버 에러');
// 					}
// 				}
// 			});
		
	});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							신청자 사진 
						</th>
						<th>
							글제목
						</th>
						<th>
							보낸 사람 id
						</th>
							<th>
							보낸 날짜 
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list}" var="vo">
			
					<tr>
						
						<td>
							${vo.user_photo }
						</td>
						<td>
							${vo.meet_name }
						</td>
						<td>
							${vo.user_id } 
						</td>
						<td>
							${vo.regist_date }
						</td>
						<td>
							<input type="button" class="btnOk" value="수락" data-join-idx="${ vo.meet_num }"  />
							<input type="button" class="btnEsc" value="거절" data-join-idx="${ vo.join_idx}"/>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>