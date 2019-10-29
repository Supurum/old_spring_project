<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../include/header.jsp"%>
<div class="container-fluid">

	<div class="row">
		<div class="col-md-2">
			<ul class="nav nav-tabs nav-stacked">
				<c:choose>
					<c:when test="${type == 'targetid'}">
						<li class="active">
							<a href="/messages/list/targetid/1">받은쪽지함</a>
						</li>
						<li>
							<a href="/messages/list/sender/1">보낸쪽지함</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<a href="/messages/list/targetid/1">받은쪽지함</a>
						</li>
						<li class="active">
							<a href="/messages/list/sender/1">보낸쪽지함</a>
						</li>
					</c:otherwise>
				</c:choose>
				
				<li >
					<a href="/messages/write">쪽지쓰기</a>
				</li>
			</ul>
		</div>
		<div class="col-md-8">
			<table class="table table-hover table-bordered table-condensed" >
				<thead>
					<tr>
						<th>
							쪽지내용
						</th>
						
						<c:choose>
							<c:when test="${type == 'sender'}">
								<th>받는사람</th>
							</c:when>
							<c:otherwise>
								<th>보낸사람</th>
							</c:otherwise>
						</c:choose>
						
						
						<th>
							보낸 날짜
						</th>
						
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="messageDTO">				
					<tr class="message_detail">
						<c:choose>
							<c:when test="${messageDTO.opendate == null}">
								<td>
									<a href="/messages/${type}/detail/${messageDTO.msg_num }" >
									<c:choose>
										<c:when test="${messageDTO.message.length() > 20 }">									
											${messageDTO.message.substring(0, 20)} ...
										</c:when>
										<c:otherwise>
											${messageDTO.message}
										</c:otherwise>
									</c:choose>
									</a>
								</td>
							</c:when>
							
							<c:otherwise>
								<td>
									<a href="/messages/${type}/detail/${messageDTO.msg_num }" style="color:gray">
									<c:choose>
										<c:when test="${messageDTO.message.length() > 20 }">									
											${messageDTO.message.substring(0, 20)} ...
										</c:when>
										<c:otherwise>
											${messageDTO.message}
										</c:otherwise>
									</c:choose>
									</a>
								</td>
							</c:otherwise>
						</c:choose>
						
						<td>
						<c:choose>
							<c:when test="${ type == 'sender' }">
							${messageDTO.user_nickname }(${messageDTO.targetid})
							</c:when>
							
							<c:otherwise>
								${messageDTO.user_nickname }(${messageDTO.sender})
							</c:otherwise>
						</c:choose>
						
						</td>
						
						<td>
							${messageDTO.senddate }
						</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
		<div class="col-md-2">
		</div>
	</div>
	<div>
	${pageMaker }
	</div>
	<div class="row">
	<div>
	</div>
		<div class="text-center">
			<ul class="pagination">
				
				<c:if test="${pageMaker.prev }">
					<li><a href="/messages/list/${type}/${pageMaker.startPage - 1}">&laquo;</a></li>
				</c:if>
					
				<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
					<li
						<c:if test="${pageMaker.cri.page == idx }">
						class="active"
						</c:if>
						><a href="/messages/list/${type}/${idx }">${idx }</a>
					</li>
				</c:forEach>
				
				<c:if test="${pageMaker.next }">
					<li><a href="/messages/list/${type}/${pageMaker.endPage + 1}">&raquo;</a></li>
				</c:if>	
			</ul>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp" %>