<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<style>
#fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: #dddddd;
	margin: auto;
}

.content {
	margin-left: 100px;
	margin-right: 100px;
}
</style>

<section class="content">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">글 작성</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post" id="registerForm">
					<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">제목</label>
							<input type="text" name="tbl_title" class="form-control" placeholder="작성하세요">
						</div>
						<div class="form-group">
							<label>작성자</label> 
							<input type="text" name="tbl_writer" class="form-control" 
								value="${ sessionScope.id }" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="tbl_content" rows="6" placeholder="작성하세요"></textarea>
						</div>
						<div class="form-group">
							<label>첨부 파일</label> 
							<div id="fileDrop"></div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer">
						<ul id="uploadedList" class="mailbox-attachments clearfix"></ul>
						
						<button type="submit" class="btn btn-primary">확인</button>
						<button type="submit" class="btn btn-warning">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>

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
<li>
	<span class="mailbox-attachment-icon has-img">
		<img src="{{imgsrc}}" alt="Attachment">
	</span>
	<div class="mailbox-attachment-info text-center">
		<a target="_blank" href="/displayFile?fileName={{getLink}}" 
			class="mailbox-attachment-name">{{fileName}}</a>
		<a class="seconda" href="{{fullName}}"
			class="btn btn-default btn-xs pull-right delbtn">
			<i class="fa fa-fw fa-remove"></i>
		</a>
	</div>
</li>
</script>

<script>
$(document).ready(function() {
	
	// 파일
	$('#fileDrop').on('dragenter dragover', function(e) {
		e.preventDefault();
	});
	
	$('#fileDrop').on('drop', function(e) {
		e.preventDefault();
		var files = e.originalEvent.dataTransfer.files;
		var file = files[0];
		var formData = new FormData();
		formData.append('file', file);
		
		$.ajax({
			'url' : '/ys/user/uploadAjax',
			'data' : formData,
			'dataType' : 'text',
			'processData' : false,
			'contentType' : false,
			'type' : 'post',
			'success' : function(rData) {
				
				var data = getDataObject(rData);
				
				var source = $('#template').html();
				var template = Handlebars.compile(source);
				var templateData = template(data);
				console.log('templateData:' + templateData);
				$('#uploadedList').append(templateData);
			}
		});
	});
			
	$('#uploadedList').on('click', '.seconda', function(e) {
		e.preventDefault();
		var that = $(this);
		var fileName = that.attr('href');
		
		$.ajax({
			'type' : 'post',
			'url' : '/board/deleteFile',
			'data' : { 'fileName' : fileName },
			'dataType' : 'text',
			'success'  : function(rData) {
				console.log('delete:' + rData);
				if (rData == 'DELETED') {
					alert('삭제 되었습니다.');
					that.parents('li').remove();
				}
			}
		});
	}); 
		
	$('#registerForm').submit(function(e) {
		e.preventDefault();
		$('#uploadedList > li').each(function(index) {
			var val = $(this).find('div > a.seconda').attr('href');
			var iHidden = '<input type="hidden" name="files[' 
				+ index + ']" value="' + val + '">';
			$(this).append(iHidden);
		});
		
		$('#registerForm').get(0).submit();
		
	});
	
	var formObj = $('form[role=form]');
	
	$('.btn-warning').on("click", function() {
		formObj.attr('action', '/board/list');
		formObj.attr('method', 'get');
		formObj.submit();
	});
	
});
</script>


<%@ include file="../include/footer.jsp" %>