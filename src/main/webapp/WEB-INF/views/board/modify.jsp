<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>

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
					<h3 class="box-title">글 수정</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post" id="modifyForm">
				
					<input type="hidden" name="page" value="${ cri.page }"/>
					<input type="hidden" name="perPageNum" value="${ cri.perPageNum }"/>

					<div class="box-body">

						<div class="form-group">
							<label for="exampleInputEmail1">번호</label> 
							<input type="text" value="${ boardVO.tbl_bno }" name='tbl_bno' class="form-control" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">작성자</label> 
							<input type="text" value="${boardVO.tbl_writer}" name="tbl_writer" class="form-control" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">제목</label> 
							<input type="text" value="${ boardVO.tbl_title }" name='tbl_title' class="form-control">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">내용</label>
							<textarea class="form-control" name="tbl_content" rows="3">${ boardVO.tbl_content }</textarea>
						</div>
						<div class="form-group">
							<label>첨부 파일</label> 
							<div id="fileDrop"></div>
						</div>
					</div>
					<div class="box-footer">
						<ul id="uploadedList" class="mailbox-attachments clearfix"></ul>
						
						<button type="submit" class="btn btn-primary">수정</button>
						<button type="button" class="btn btn-warning">취소</button>
					</div>
				</form>
					
			</div>
		</div>

	</div>
</section>

<form role="form" action="/board/list" id="cancelForm" method="get">
	<input type="hidden" name="page" value="${ cri.page }">
	<input type="hidden" name="perPageNum" value="${ cri.perPageNum }">
</form>

<script>
function checkImage(fileName) {
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
	
	
	var cancelForm = $('#cancelForm');
	
	// 수정
	$('.btn-primary').click(function(e) {
		
		e.preventDefault();
		$('#uploadedList > li').each(function(index) {
			var val = $(this).find('div > a.seconda').attr('href');
			var iHidden = '<input type="hidden" class="attachFile" name="files[' 
				+ index + ']" value="' + val + '">';
			$(this).append(iHidden);
		});		
		$('#modifyForm').get(0).submit();

	});
	// 취소
	$('.btn-warning').click(function() {
		cancelForm.submit();
	});
});
</script>

<%@include file="../include/footer.jsp"%>
