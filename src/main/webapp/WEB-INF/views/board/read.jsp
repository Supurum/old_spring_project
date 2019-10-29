<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

<style>
	.popup { position: absolute; }
	.back { 
		background-color: gray;
		opacity: 0.5;
		width: 100%;
		height: 300%;
		overflow: hidden;
		z-index: 1101;
	}
	
	.front {
		z-index: 1110;
		opacity: 1;
		border: 1px;
		margin: auto;
	}

	.show {
		position: relative;
		max-width: 1200px;
		max-height: 800px;
		overflow: auto;
	}
	
	.content {
		margin-left: 100px;
		margin-right: 100px;
	}
	
	.timeline-item {
		padding-left: 10px;
	}
	
	.row {
		
	}
</style>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">글 읽기</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<input type="hidden" name="tbl_bno" value="${ boardVO.tbl_bno }"/>
				</form>
				
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">제목</label>
						<input type="text" value="${ boardVO.tbl_title }" name='tbl_title' class="form-control" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">작성자</label>
						<input type="text" value="${ boardVO.tbl_writer }"
							name="tbl_writer" class="form-control" readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">내용</label>
						<ul id="uploadedList" class="mailbox-attachments clearfix">
							<li><img src="/displayFile?fileName=${boardVO.files[0] }"/></li>
						</ul>
						<textarea class="form-control" name="tbl_content" rows="6" readonly="readonly">
							${ boardVO.tbl_content }</textarea>
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
				<c:if test="${ sessionScope.id eq boardVO.tbl_writer }">
					<button type="submit" class="btn btn-warning">수정</button>
					<button type="submit" class="btn btn-danger">삭제</button>
				</c:if>
					<button type="submit" class="btn btn-info">목록</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 댓글 -->
	<div class="row">
		<div class="col-md-12">
		
			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="repliesDiv" style="cursor: pointer;">
					<span class="bg-green">댓글 리스트 [${boardVO.tbl_replycnt}]</span>
				</li>
			</ul>
			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">
				</ul>
			</div>
		
			<!-- 로그인한 사용자만 댓글 쓰기 가능 -->
<%--  			<c:if test="${ sessionScope.id }"> --%>
			<div class="box box-success">
			
			
				<div class="box-header">
					<h3 class="box-title">댓글 목록</h3>
				</div>
				<div class="box-body">
					<label for="exampleInputEmail1">작성자</label> 
					<input class="form-control" type="text" id="newReplyWriter" 
					value="${ sessionScope.id }" readonly="readonly">
					<label for="exampleInputEmail1">댓글</label> 
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary" id="replyAddBtn">댓글 입력</button>
				</div>
			</div>
<%--  			</c:if> --%>
		</div>
		<!-- /.col -->
	</div>
</section>



<form role="form" method="post">
	<input type="hidden" name="tbl_bno" value="${ boardVO.tbl_bno }"/>
	<input type="hidden" name="page" value="${ cri.page }"/>
	<input type="hidden" name="perPageNum" value="${ cri.perPageNum }"/>
	<input type="hidden" name="searchType" value="${ cri.searchType }"/>
	<input type="hidden" name="keyword" value="${ cri.keyword }"/>
</form>

<script>
function checkImage(fileName) {
	// 이미지인 아닌지 체크 - 확장자 얻기
	var dotIndex = fileName.lastIndexOf('.');
	var formatName = fileName.substring(dotIndex + 1).toUpperCase();
	
	if (formatName == 'JPG' || formatName == 'GIF' || formatName == 'PNG') {
		return true;
	} else {
		return false;
	}
}

function getDataObject(fName) {
	
	var isImage = checkImage(fName);
	// 이미지인 경우
	if (isImage == true) {
		var imgsrc = '/ys/user/displayFile?fileName=' + fName;
		
		var sIndex = fName.indexOf('s');
		var preStr = fName.substring(0, sIndex);
		var postStr = fName.substring(sIndex + 2);
		var getLink = preStr + postStr;

	} 
	// 이미지가 아닌 경우
	else {
		var imgsrc = '/resources/dist/img/file.png';
		var getLink = fName;
	}
	
	var uIndex = getLink.indexOf('_');
	var fileName = getLink.substring(uIndex + 1);
	var fullName = fName;
	
	var data = {
			'imgsrc' : imgsrc,
			'getLink' : getLink,
			'fileName' : fileName,
			'fullName' : fullName
	};
	
	return data;
}
</script>

<script id="template" type="text/x-handlebars-template">
{{#each .}}
	<li class="replyLi" data-re_rno="{{re_rno}}">
		<div class="timeline-item" style="border: 1px solid #808080;"">
			<h3 class="timeline-header"><span>{{re_replyer}}</span></h3>
			<div class="timeline-body">{{re_text}}</div>
			<div class="time-footer">
			
				{{#eqReplyer re_replyer}}
					<a class="btn btn-warning btn-xs btn-delete">삭제</a>
				{{/eqReplyer}}
			
			</div>
			<span class="time">
				<i class="fa fa-clock-o"></i>{{prettyDate re_regdate}}
			</span>
		</div>
	</li>
{{/each}}
</script>

<script>

	Handlebars.registerHelper("prettyDate", function(regdate) {
		var dateObj = new Date(regdate);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + '/' + month + '/' + date;
	});
	
	Handlebars.registerHelper("eqReplyer", function(re_replyer, block) {
		
		if (re_replyer == '${ sessionScope.id }') {
			return block.fn();	
		} else {
			return '';
		}
	});

	
</script>

<script id="templateAttach" type="text/x-handlebars-template">
<li data-src="{{fullName}}">
	<span class="mailbox-attachment-icon has-img">
		<img src="{{imgsrc}}" alt="Attachment">
	</span>
	<div class="mailbox-attachment-info">
		<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</div>
</li>
</script>

<script>
$(document).ready(function() {
	
	var re_bno = '${boardVO.tbl_bno}';
	
	var formObj = $('form[role=form]');
	
	function getPageList(page) {
		
		$.getJSON('/board/replies/' + re_bno + '/' + page, function(rData) {
			var data = rData.list;
			rData.login_id = '${sessionScope.id}';
			var source = $('#template').html();
			var template = Handlebars.compile(source);
			var html = template(data);
			$('.timeline > li.replyLi').remove();
			$('.timeline').append(html);
			printPaging(rData.pageMaker);
		});
	}
	
	function printPaging(pageMaker) {
		var str = '';
		
		if(pageMaker.prev == true) {
			str += '<li><a href="' + (pageMaker.startPage - 1) + '">이전</li>'; 
		}
		
		for(var i = pageMaker.startPage; i <= pageMaker.endPage; i++) {
			str += '<li><a href="' + i + '">' + i + '</a></li>';
		}
		
		if(pageMaker.next == true) {
			str += '<li><a href="' + (pageMaker.endPage + 1) +'">다음</li>'; 
		}
		
		$('#pagination').html(str);
		
		$('.btn-reply').on('click', function() {
	 		$(this).parent().next().slideDown('1000');
	 	});
		
		$('.btn-input').on('click', function() {
			var re_replyer = $('.box-header').val();
			var re_text = $(".box-body").val();
			console.log(re_replyer);
			console.log(re_text);
			
			$.ajax({
				type : 'post',
				url : '/board/replies',
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({re_bno : re_bno, re_replyer : re_replyer, re_text : re_text}),
				success : function(rData) {
					if(rData == 'SUCCESS') {
						alert("등록 되었습니다.");
						replyPage = 1;
						getPage("/replies/" + re_bno + "/" + replyPage);
					}
				}
			});
		});
		
		$('.btn-delete').on('click', function() {
			var re_rno = $(this).parents('.replyLi').attr('data-re_rno');
			$.ajax({
				type : 'delete',
				url : '/board/replies/' + re_rno,
				headers : {
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "DELETE"
				},
				dataType : 'text',
				success : function(rData) {
					if(rData == 'SUCCESS') {
						alert("삭제 되었습니다");
						getPageList(1);
					}
				}
			});
		});
	}
	
	// 수정
	$('.btn-warning').on("click", function() {
		formObj.attr('action', '/board/modify');
		formObj.attr('method', 'get');
		formObj.submit();
	});
	// 삭제
	$('.btn-danger').on("click", function() {
		formObj.attr('action', '/board/remove');
		formObj.submit();
	});
	// 리스트
	$('.btn-info').on("click", function() {
		formObj.attr('action', '/board/list');
		formObj.attr('method', 'get');
		formObj.submit();
	});
	
	
	
	// 댓글 입력
	$('#replyAddBtn').click(function() {
		var re_replyer = $('#newReplyWriter').val();
		var re_text = $("#newReplyText").val();
		var url = '/board/replies';
		var tbl_bno = ${boardVO.tbl_bno}
		console.log(re_replyer);
		console.log(re_text);
		var data = {
				're_bno' : tbl_bno,
				're_replyer' : re_replyer,
				're_text' : re_text
		};
		console.log('data:' + data);
		$.get(url,data, function(rData) {
			if (rData == 'SUCCESS') {
					alert('등록 되었습니다.');
 					getPageList(1);
 					$('#newReplyWriter').val('');
 					$('#newReplyText').val('');
 					console.log(newReplyWriter);
 					console.log(newReplyText);
 					
				}
		});
	});
	
	$('.timeline').on('click', '.btn-primary ', function(e){
		e.preventDefault();
		var p = $(this).parents('.timeline-item');
		var re_replyer = p.find('.timeline-header > span').text();
		var re_text = p.find('.timeline-body').text();
		$('#re_replyer').val(re_replyer);
		$('#re_text').val(re_text);
	});
	
	// 댓글 리스트 클릭
	$('#repliesDiv').click(function() {
		
		var count = $('.timeline > li.replyLi').size();
		if (count > 0) {
			return;
		}
		getPageList(1);
	});
	
	// 페이징
	$('#pagination').on('click', 'li > a', function(e) {
		e.preventDefault();
		var replyPage = $(this).attr('href');
		getPageList(replyPage);
	});
	
	// 파일
	$.getJSON('/board/getAttach/' + re_bno, function(rData) {
		console.log('rData', rData);
		var list = $(rData);
		list.each(function(index) {
			var fName = rData[index];
			
			var data = getDataObject(fName);
			console.log(data);
			
			var source = $('#templateAttach').html();
			var template = Handlebars.compile(source);
			var templateData = template(data);
			$('#uploadedList').append(templateData);
			console.log(templateData);
		});
	});
	
	$('#uploadedList').on('click', '.mailbox-attachment-info > a', function(e) {
		e.preventDefault();
		
		var fileLink = $(this).attr('href');
		var imgTag = $('#popup_img');
		imgTag.attr('src', '/displayFile?fileName=' + fileLink);
		$('.popup').fadeIn('slow');
		imgTag.addClass('show');
	});
	
	$('#popup_img').click(function() {
		$('.popup').fadeOut('fast');
	});
	
	
});
</script>


<%@include file="../include/footer.jsp"%>
