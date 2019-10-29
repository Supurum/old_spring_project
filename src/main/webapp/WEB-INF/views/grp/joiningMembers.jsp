<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="dto" items="${list}">

	<li class="col-sm-3">
		<div class="item">
			<div class="thumbnail">
				<img src="${dto.user_photo}" alt="">
			</div>
			<div class="caption">
				<h4 class="caption_id">
					회원 아이디 : <span>${dto.user_id}</span>
				</h4>
				<p class="caption_name">
					이름 : <span>${dto.user_name}</span>
				</p>
				<p class="caption_age">
					나이 : <span>${dto.user_age}</span>
				</p>
				<p class="caption_gender">
					성별 : <span>${dto.gender_name}</span>
				</p>
				<a class="btn btn-mini" href="#">» Read More</a>
			</div>
		</div>
	</li>

</c:forEach>