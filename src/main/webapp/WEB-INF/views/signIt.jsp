<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include/header.jsp"%>

<style>
#fileDrop {
	width: 80%;
	height: 100px;
	border: 1px dotted gray;
	background-color: #dddddd;
	margin: auto;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	$(function() {
		
		$('#btnsubmit').click(function() {
			$('#note').empty();
			var id = $('#id').val();
			var password = $('#pw').val();
			var name = $('#name').val();
			var nick = $('#nickName').val();
			// 		var cpassword=$('#cpw').val();
			var idcheck = document.getElementById("idchkresult").textContent;
			var pwcheck = document.getElementById("pwchkresult").textContent;
			var nickcheck = document.getElementById("nickNamechkresult").textContent;
			
			id= id.trim();
			password = password.trim();
			name = name.trim();
			nick = nick.trim();
			//console.log("'"+id+"','"+password+"'");

			// 		if(password!=cpassword){
			// 			$('#note').append("<tr><td>비밀번호가 일치하지 않습니다.</td></tr>");
			// 		}
			if (id == "") {
				$('#note').append("<tr><td>아이디를 입력하세요.</td></tr>");
			}
			if (password == "") {
				$('#note').append("<tr><td>비밀번호를 입력하세요.</td></tr>");
			}
			if (name == "") {
				$('#note').append("<tr><td>이름은 필수입력항목입니다.</td></tr>");
			}
			if (nick == "") {
				$('#note').append("<tr><td>닉네임은 필수입력항목입니다.</td></tr>");
			}

			if (idcheck == "") {
				$('#note').append("<tr><td>아이디 체크가 필요합니다.</td></tr>");
			} else {
				if (idcheck == "사용가능") {

				} else {
					$('#note').append("<tr><td>이미 존재하는 아이디입니다.</td></tr>");
				}
			}
			if (nickcheck == "") {
				$('#note').append("<tr><td>닉네임 체크가 필요합니다.</td></tr>");
			} else {
				if (nickcheck == "사용가능") {

				} else {
					$('#note').append("<tr><td>이미 존재하는 닉네임입니다.</td></tr>");
				}
			}
			if (pwcheck == "비밀번호 불일치" || pwcheck == "") {
				$('#note').append("<tr><td>비밀번호가 일치하지 않습니다.</td></tr>");
			}
			var re = $('#note').children().length;
			console.log(re);
			if (re == 0) {
				$('#SignForm').submit();
			}

		})
		$('#id').on('change', function() {
			var id = $('#id').val();
			id = id.trim();
			if (id == "") {

				return;
			}
			$('#id').val(id);
			$.getJSON('/ys/AJAX/id/' + id, function(result) {
				var r = result.result;
				var span = $('#idchkresult');
				if (r == '') {
					span.text('사용가능');
				} else {
					if (r == 'null') {
						span.text('서버오류');
					} else {
						span.text(r);
					}
				}
			});
		});
		// .chage -> <select>태그
		$('#nickName').on('change', function() {
			var nick = $('#nickName').val();
			nick = nick.trim();
			if (nick == "") {

				return;
			}
			$('#nickName').val(nick);
			$.getJSON('/ys/AJAX/nickName/' + nick, function(result) {
				var r = result.result;
				var span = $('#nickNamechkresult');
				if (r == '') {
					span.text('사용가능');
				} else {
					if (r == 'null') {
						span.text('서버오류');
					} else {
						span.text(r);
					}
				}
			});
		});
		function pwdchk(p, cp) {
			var password = p.val();
			password = password.trim();
			p.val(password);

			var cpassword = cp.val();
			cpassword = cpassword.trim();
			cp.val(cpassword);
			var span = $('#pwchkresult');

			if (password == "" || cpassword == "") {
				span.text('');
				return;
			}

			if (password == cpassword) {
				span.text("비밀번호 일치");
			} else {
				span.text("비밀번호 불일치");
			}

		}
		$('#cpw').on('input', function() {
			pwdchk($('#pw'), $('#cpw'));
		});
		$('#pw').on('input', function() {
			pwdchk($('#pw'), $('#cpw'));
		});
	});
</script>
<div class="container" align="center">
	<H1>회원가입</H1>
	${ re }
	<form action="SignItAction" method="post" class="form-signin"
		id="SignForm" enctype="multipart/form-data">
		<div class="box-body">
			<table>
				<tr>
					<td><input type="text" id="id" name="user_id"
						class="form-control" placeholder="아이디" required /> <!-- 						<input type="button" id="ipChk" value="중복확인"> -->
						<div id="idchkresult"></div></td>
				</tr>
				<tr>
					<td><input type="password" id="pw" name="user_pw"
						class="form-control" placeholder="비밀번호" required /></td>
				</tr>
				<tr>
					<td><input type="password" id="cpw" class="form-control"
						placeholder="비밀번호 확인" required /></td>
				</tr>
				<tr>
					<td>
						<div id="pwchkresult"></div>
					</td>
				</tr>
				<tr>
					<td><input type="text" id="name" name="user_name"
						class="form-control" placeholder="이름" required /></td>
				</tr>
				<tr>
					<td>성별 <select name="user_gender">
							<c:forEach items="${ genderlist }" var="genderlist">
								<c:if test="${ genderlist.gender_num ne 0}">
									<option value="${ genderlist.gender_num }">${ genderlist.gender_name }</option>
								</c:if>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="text" id="nickName" name="user_nickname"
						class="form-control" placeholder="닉네임" required />
						<div id="nickNamechkresult"></div>
					</td>
				</tr>
				<tr>
					<td>나이 <input type="number" id="year" name="user_age" min="1"
						max="130" value="0" required /></td>
				</tr>
				<tr>
					<td>거주지 <select name="user_addr">
							<c:forEach items="${ loclist }" var="loclist">
								<option value="${ loclist.loc_num }">${ loclist.loc_name }</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<!--USER_TEL-->
				<tr>
					<td><input type="text" id="tel" name="user_tel"
						class="form-control" placeholder="전화번호" required /></td>
				</tr>
				<tr>
					<td>종교 <select name="user_religion">
							<c:forEach items="${ religionlist }" var="religionlist">
								<option value="${ religionlist.religion_num }">${ religionlist.religion_name }</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<!--USER_PHOTO -->
				<tr>
					<td>
						<!-- 			17.11.22		<input type="file" name="file" required/> -->
						<div class="form-group">
							<label>File DROP Here</label>
							<div id="fileDrop"></div>
						</div>
						<ul id="uploadedList" class="mailbox-attachments clearfix">
						</ul>
					</td>
				</tr>
				<tr>
					<td>
						<div id="note"></div>
					</td>
				</tr>
				<tr>
					<td align="center"><input type="button"
						class="btn btn-success" id="btnsubmit" value="가입" /></td>
				</tr>

			</table>
		</div>
	</form>
</div>
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
		var imgsrc = '/displayFile?fileName=' + fName;
		
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
		<a target="_blank" href="user/displayFile?fileName={{getLink}}" 
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
			'url' : '/uploadAjax',
			'data' : formData,
			'processData' : false,
			'contentType' : false,
			'type' : 'post',
			'success' : function(rData) {
				
				// resouces/js/myfunc.js
				var data = getDataObject(rData);
				
				var source = $('#template').html();
				var template = Handlebars.compile(source);
				var templateData = template(data);
				console.log('templateData:' + templateData);
				//파일 삭제
				if ( $('#uploadedList').children().length > 0 ) {
					var that = $('#uploadedList>li>div>a');
					var fileName = that.attr('href');					
					$.ajax({
						'type' : 'post',
						'url' : '/deleteFile',
						'data' : { 'fileName' : fileName },
						'dataType' : 'text',
						'success'  : function(dData) {
							console.log('delete:' + dData);
							if (dData == 'DELETED') {
// 								alert('삭제 되었습니다.');
							}
						}
					});
					//화면 삭제
					$('#uploadedList').empty();
				}
// 				//화면 추가
				$('#uploadedList').append(templateData);
			}
		}); // $.ajax
	}); // $('#fileDrop').on('drop'
			
	$('#uploadedList').on('click', '.seconda', function(e) {
		e.preventDefault();
		var that = $(this);
		var fileName = that.attr('href');
		
		$.ajax({
			'type' : 'post',
			'url' : '/deleteFile',
			'data' : { 'fileName' : fileName },
			'dataType' : 'text',
			'success'  : function(rData) {
				console.log('delete:' + rData);
				if (rData == 'DELETED') {
					alert('삭제 되었습니다.');
					that.parents('li').remove();
				}
			}
		}); // $.ajax
	}); // $('#uploadedList').on('click',
	$('#SignForm').submit(function(e) {
		e.preventDefault();
		$('#uploadedList > li').each(function(index) {
				var val = $(this).find('div > a.seconda').attr('href');
				var iHidden = '<input type="hidden" name="files" value="' + val + '">';
				$(this).append(iHidden);
		});
		
		$('#SignForm').get(0).submit(); // get(0) -> DOM 객체(form)
		// -> 폼을 전송
		
	});
});
</script>
<%@include file="include/footer.jsp"%>