<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- 구글경로JQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- JSTL Core -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> --%>
<%-- <%@ taglib prefix="sql" uri=" http://java.sun.com/jsp/jstl/sql"%> --%>
<%-- <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%> --%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.min.js"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<br/><br/><br/><br/><br/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="assets/ico/favicon.ico">


    <!-- Bootstrap core CSS -->
    <link href="/resources/assets/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/assets/css/style.css" rel="stylesheet">
    <link href="/resources/assets/css/font-awesome.min.css" rel="stylesheet">


    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script src="/resources/assets/js/modernizr.js"></script>

<div>


<!-- <nav class="navbar navbar-default" role="navigation"> -->
<!-- 	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> -->
<!-- 		<ul class="nav navbar-nav" id="lnb"> -->
<%-- 			<c:forEach items="${mainList}" var="mainList"> --%>
<!-- 				메인메뉴 -->
<!-- 				<li> -->
<!-- 					<a href=""> -->
<%-- 						${mainList.main_category_name}	 --%>
<!-- 					</a> -->
<!-- 					서브메뉴 -->
<%-- 					<c:if test="${ mainList.main_category_name eq '짧은 만남' }"> --%>
<!-- 						<ul class="nav navbar-nav" style="display:block;"> none: 보이지 않음, block: 보이기 -->
<%-- 							<c:forEach items="${subList}" var = "subList"> --%>
<!-- 								<li> -->
<!-- 									<a href=""> -->
<%-- 										${subList.category_name} --%>
<!-- 									</a> -->
<!-- 								</li> -->
<%-- 							</c:forEach> --%>
<!-- 						</ul> -->
<%-- 					</c:if> --%>
<!-- 				</li> -->
<%-- 			</c:forEach> --%>
<!-- 		</ul> -->
<!-- 	</div> -->
<!-- </nav> -->
<div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/intro">매칭매칭돌려매칭</a>
        </div>
        <div class="navbar-collapse collapse navbar-right">
          <ul class="nav navbar-nav">
            	
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    <br/><br/>
<script id="maintemplate" type="text/x-handlebars-template">
{{#each .}}
<li>
	<a href="{{main_category_url}}">
		{{main_category_name}}
	</a>
</li>
{{/each}}
</script>
<script type="text/javascript">	
	$(function() {
		$.getJSON('/ys/MENU/getMain', function(result) {
			var mainList = result.mainList;
			var source = $('#maintemplate').html();//양식
			var template = Handlebars.compile(source);
			var html = template(mainList);
			var sessioninid = '${sessionScope.id}';
			
			if(sessioninid != null && sessioninid != ''){
				html=html+'<li><a href="/cert">마이 페이지</a></li>';
				html=html+'<li><a href="/logout">로그아웃</a></li>';
				
			}
			else{
				html=html+'<li><a href="/login">로그인</a></li>'
			}
			$('.navbar-nav').append(html);
		});
	});
</script>