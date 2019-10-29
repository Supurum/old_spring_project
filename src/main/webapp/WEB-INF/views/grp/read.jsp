<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">									
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>									
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<div class="container-fluid">

	<div class="row">
		<div class="col-md-2">
			<ul class="nav nav-stacked nav-tabs">
				<li>
					<a href="/grp/listAll">전체목록</a>
				</li>
				<li>
					<a href="/grp/list/${page }">이전페이지</a>
				</li>
			</ul>
		</div>
		<div class="col-md-10"> 
		<h3><b>&lt; ${dto.state_name } &gt;</b></h3>
		</div><br/>
	</div>

	<div class="row">
		<div class="col-sm-2">
		</div>
		
		<div class="col-sm-2">
			<img alt="사진없음" src="/resources/images/1.jpg" class="img-thumbnail" />
		</div>
		<div class="col-md-3" style="font-size:15">
			<div class="lib-row lib-header">
	           <h4><b> &lt; 모집장 &gt; &nbsp;&nbsp;${dto.meet_writer }</b></h4>
	        </div>
	        <div class="lib-row lib-desc">
               	${dto.meet_name }<br/>
	        	만남지역 : ${dto.loc_name}<br/>
	        	이름 : ${dto2.user_name }<br/>
	        	나이 : ${dto2.user_age }<br/>
	        	성별 : ${dto2.gender_name }<br/>
	        	종교 : ${dto2.religion_name }<br/><br/>
            
            <c:choose>
            	<c:when test="${sessionScope.id == dto.meet_writer}">
            		<c:if test="${dto.meet_state == 'w'}">
	            		<input type="button" id="stateBtn" value="모집완료"/>
            			<input type="button" id="stateDelBtn" value="모집삭제"/>
            		</c:if>
            		<c:if test="${dto.meet_state == 'i'}">
            			<input type="button" id="stateIngBtn" value="모집중"/>
            			<input type="button" id="stateDelBtn" value="모집삭제"/>
            		</c:if>
            	</c:when>
            	<c:otherwise>
		           	<c:if test="${dto.meet_state == 'w'}">
		           		<input type="button" id="joinBtn" value="참가신청" data-meet-num="${ dto.meet_num }"/>            	
		           	</c:if>
            	</c:otherwise>
            </c:choose>
            	
            </div><br/><br/>
		</div>
		
		<div class="col-md-3" style="font-size:15">
			<div class="lib-row lib-header">
	           <h4><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &lt; 모집장 &gt;</b></h4>
	        </div>
	        <div>
	        	이름 : ${dto2.user_name }<br/>${list}
	        	나이 : ${dto2.user_age }<br/>
	        	성별 : ${dto2.gender_name }<br/>
	        	
	        </div>
		</div>
	</div>
</div><br/><br/>


<input type="hidden" name="stateCh" value="${dto.meet_state }"/>

<div class="container">
<div class="col-xs-12">

    <div class="page-header">
        <h3>현재 참여 인원들 (${dto.meet_peoplenum }명) 최대(${dto.meet_maxpeoplenum }명)</h3>
    </div>
    <div>
        <div class="carousel-inner">
            <div class="item active" id="partnerList">    
            <ul class="thumbnails">      	
        	<c:forEach var="dto" items="${list}">
                    
                        <li class="col-sm-3">
    						<div class="item">
								<div class="thumbnail">
									<img src="${dto.user_photo}" alt="">
								</div>
								<div class="caption">
									<h4 class="caption_id">회원 아이디 : <span>${dto.user_id}</span></h4> 
									<p class="caption_name">이름 : <span>${dto.user_name}</span></p>
									<p class="caption_age">나이 : <span>${dto.user_age}</span></p>
									<p class="caption_gender">성별 : <span>${dto.gender_name}</span></p>
									<a class="btn btn-mini" href="#">» Read More</a>
								</div>
                            </div>
                        </li>
                                    
              </c:forEach>
              </ul>   
              </div><!-- /Slide1 -->            
        </div>
              
	   <nav>
			<ul class="control-box pager">
				<li><a data-slide="prev" class="prevPartner"><i class="glyphicon glyphicon-chevron-left"></i></a></li>
				<li><a data-slide="next" class="nextPartner"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
			</ul>
	   </nav><!-- /.control-box -->                                
    </div><!-- /#myCarousel -->       
</div><!-- /.col-xs-12 -->          
</div><!-- /.container -->

<script>
$(document).ready(function(){
	
	//삭제시
	$("#stateDelBtn").click(function(){
		location.href = "/grp/state/${dto.meet_num }/c";
	});
	
	//모집완료 눌렀을때
	$("#stateBtn").click(function(){
		location.href = "/grp/state/${dto.meet_num }/i";		
	});
	
	//모집중 눌렀을때
	$("#stateIngBtn").click(function(){
		location.href = "/grp/state/${dto.meet_num}/w";
	});
	
	// 참가신청 눌렀을때
	$('#joinBtn').click(function(){
// 		data-meet-num
		var meet_num = $(this).attr('data-meet-num');
		data = {
			'meet_num' : meet_num,
			'meet_writer' : '${dto.meet_writer }'
		};
		
		$.ajax({
			'url' : '/registShow/meet_request',
			'data' : data,
			'dataType' : 'text',
			'type' : 'post',
			'success' : function(rData){
				console.log('rData', rData);
				if(rData == 'SUCCESS'){
					alert('신청 되었습니다');
				} else if(rData == 'FAIL'){
					alert('이미 신청하셨습니다.');
				}
			}
		});
	}); //참가신청 ajax
	
	var subpage = 1;
	
	//참여인원 리스트 next버튼
	$(".nextPartner").click(function(){
		var meet_num = '${ dto.meet_num }';
		
		data = {
				'meet_num' : meet_num,
				'subpage' 	: ++subpage,
				'perPageNum' : 4
		}; 
		
		$('.thumbnails').load('/grp/listPartner', data, function(html) { 
			console.log(html);
		});
// 		$.get('/grp/listPartner', data, function(rData){
// 			console.log('rData', rData);
// 			console.log('Data', data);
// 			console.log(rData.length);
// 			for (var v = 0; v < rData.length; v++) {
// 				$('.thumbnail > img').eq(v).attr("src", rData[v].user_photo);
// 				$('.caption > .caption_id > span').eq(v).text(rData[v].user_id);
// 				$('.caption > .caption_name > span').eq(v).text(rData[v].user_name);
// 				$('.caption > .caption_age > span').eq(v).text(rData[v].user_age);
// 				$('.caption > .caption_gender > span').eq(v).text(rData[v].gender_name);
// 			};
			
// 			var t = 4;
// 			for (var v = t-1; v >= rData.length; v--) {
// 				console.log('v:' + v);
// 				console.log($('ul.thumbnails > li').eq(v));
// 				$('ul.thumbnails > li').eq(v).remove();
// 			};
			
			
// 		}); //$.get			
	}); // nextPartner
	
	$(".prevPartner").click(function(){
		var meet_num = '${ dto.meet_num }';
		
		data = {
				'meet_num' : meet_num,
				'subpage' 	: --subpage,
				'perPageNum' : 4
		}; 
// 		$.get('/grp/listPartner', data, function(rData){
// 			console.log('rData', rData);
// 			console.log('Data', data);
// 			console.log(rData.length);
// 			for (var v = 0; v < rData.length; v++) {
// 				$('.thumbnail > img').eq(v).attr("src", rData[v].user_photo);
// 				$('.caption > .caption_id > span').eq(v).text(rData[v].user_id);
// 				$('.caption > .caption_name > span').eq(v).text(rData[v].user_name);
// 				$('.caption > .caption_age > span').eq(v).text(rData[v].user_age);
// 				$('.caption > .caption_gender > span').eq(v).text(rData[v].gender_name);
// 			};
// 		}); //$.get		

		$('.thumbnails').load('/grp/listPartner', data, function(html) { 
			console.log(html);
		});
	});
	
});

</script>
